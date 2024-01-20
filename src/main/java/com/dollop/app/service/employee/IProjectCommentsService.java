package com.dollop.app.service.employee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.Comments;
import com.dollop.app.entity.payload.admin.CommentsRequest;
import com.dollop.app.entity.payload.admin.CommentsResponse;

public interface IProjectCommentsService {

	public Comments addComment(List<MultipartFile> files, CommentsRequest commentsRequest);

	public CommentsResponse updateProjectComment(CommentsRequest commentsRequest);

	public CommentsResponse getProjectCommentById(Long id);

	public Page<CommentsResponse> getProjectCommentsByProjectId(Integer pageNo, Integer pageSize, Integer projectId);

	public Page<CommentsResponse> getProjectCommentsByTaskId(Integer pageNo, Integer pageSize, Long taskId);

	public Boolean deleteProjectCommentById(Long id);

}
