package com.dollop.app.service;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;

public interface IAssetsService {

	public AssetsResponse addAssets(AssetsRequest assets);

	public AssetsResponse updateAssets(AssetsRequest assets);

	public AssetsResponse getAssetsById(Long id);

	public Page<AssetsResponse> getAllAssets(Integer pageNo, Integer pageSize);

	public Boolean deleteAssets(Long id);

	public AssetsResponse updateAssetsStatus(Long id, String status);

	public Page<AssetsResponse> searchAssets(Integer pageNo, Integer pageSize, AssetsRequest assets);

}
