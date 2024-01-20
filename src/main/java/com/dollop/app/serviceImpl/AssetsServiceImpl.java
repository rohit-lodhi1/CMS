package com.dollop.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Assets;
import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.AssetsRepository;
import com.dollop.app.service.IAssetsService;

@Service
public class AssetsServiceImpl implements IAssetsService {

	@Autowired
	public AssetsRepository assetsRepository;

	@Autowired
	private ModelMapper modelMapper;

	public AssetsResponse assetsToAssetsResponse(Assets assets) {
		return this.modelMapper.map(assets, AssetsResponse.class);
	}

	public Assets assetstRequestToAssets(AssetsRequest assetsRequest) {
		return this.modelMapper.map(assetsRequest, Assets.class);
	}

	// create assets
	@Override
	public AssetsResponse addAssets(AssetsRequest assets) {
		Assets asset = this.assetstRequestToAssets(assets);
		return this.assetsToAssetsResponse(this.assetsRepository.save(asset));

	}

	@Override
	public AssetsResponse updateAssets(AssetsRequest assets) {
		Assets asset = this.assetsRepository.findById(assets.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ASSEST_LIST_NOT_FOUND + assets.getId()));
		asset.setAmount(assets.getAmount());
		asset.setAssetName(assets.getAssetName());
		asset.setAssetUser(assets.getAssetUser());
		asset.setAssetWarrenty(assets.getAssetWarrenty());
		asset.setCondition(assets.getCondition());
		asset.setDescription(assets.getDescription());
		asset.setManufacturer(assets.getManufacturer());
		asset.setModel(assets.getModel());
		asset.setPurchaseDate(assets.getPurchaseDate());
		asset.setPurchaseFromDate(assets.getPurchaseFromDate());
		asset.setSerialNumber(assets.getSerialNumber());
		asset.setStatus(assets.getStatus());
		asset.setSupplier(assets.getSupplier());

		return this.assetsToAssetsResponse(this.assetsRepository.save(asset));
	}

	@Override
	public AssetsResponse getAssetsById(Long id) {

		Assets asset = this.assetsRepository.findByIdAndIsDelete(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ASSEST_LIST_NOT_FOUND + id));
		return this.assetsToAssetsResponse(asset);

	}

	@Override
	public Page<AssetsResponse> getAllAssets(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Assets> page = this.assetsRepository.findByIsDelete(pageRequest, false);

		return page.map(c -> this.assetsToAssetsResponse(c));

	}

	@Override
	public Boolean deleteAssets(Long id) {
		Assets asset = this.assetsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ASSEST_LIST_NOT_FOUND + id));
		asset.setIsDelete(true);
		this.assetsRepository.save(asset);
		return true;
	}

	@Override
	public Page<AssetsResponse> searchAssets(Integer pageNo, Integer pageSize, AssetsRequest assets) {
		// goalList.setGoalType(null);
	//	assets.getAssetUser().setDesignation(null);
		System.out.println(assets);
		assets.getAssetUser().setId(null);;
		assets.getAssetUser().setIsAdmin(null);
		assets.getAssetUser().setIsPrime(null);
		assets.getAssetUser().setEnableWebNotification(null);
		assets.getAssetUser().setEnableEmailNotification(null);
		assets.getAssetUser().setDisableLogin(null);
	

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Long) id == 0) ? null : id)))// for
				.withMatcher("amount", match -> match.transform(value -> value.map(id -> ((Long) id == 0) ? null : id)));
			
		Example<Assets> example = Example.of(this.assetstRequestToAssets(assets), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<Assets> page = this.assetsRepository.findAll(example, pageable);

		return page.map(u -> this.assetsToAssetsResponse(u));
	}

	@Override
	public AssetsResponse updateAssetsStatus(Long id, String status) {
		Assets asset = this.assetsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ASSEST_LIST_NOT_FOUND + id));
		asset.setStatus(status);
		return this.assetsToAssetsResponse(this.assetsRepository.save(asset));

	}

}
