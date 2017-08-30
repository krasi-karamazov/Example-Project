package com.mentormate.tcos.network.services;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mentormate.tcos.network.model.BaseResponse;
import com.mentormate.tcos.network.model.BasicPostResponse;
import com.mentormate.tcos.network.model.DetailedBidRequest;
import com.mentormate.tcos.network.model.BidRequestPointsResponse;
import com.mentormate.tcos.network.model.BidRequestsDetailsResponse;
import com.mentormate.tcos.network.model.ContractorActivityStreamBody;
import com.mentormate.tcos.network.model.ContractorActivityStreamResponse;
import com.mentormate.tcos.network.model.ContractorJobsResponse;
import com.mentormate.tcos.network.model.DetailedJob;
import com.mentormate.tcos.network.model.PointDetailsResponse;
import com.mentormate.tcos.network.model.ProjectDetailsResponse;
import com.mentormate.tcos.network.model.ProjectScopeToAssessmentBody;
import com.mentormate.tcos.network.model.PropertyJobsDetailsResponse;
import com.mentormate.tcos.network.model.StartAssessmentBody;
import com.mentormate.tcos.network.model.WorkInADetailedJobResponse;
import com.mentormate.tcos.network.model.WorkInfoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ContractorService {

    /**
     * Commands
     */

    @POST("/pa/Commands/Assessment/AddProjectScopeToAssessment")
    Call<BasicPostResponse> addProjectScopeToAssessment(@Header("Content-Type") @NonNull final String contentType,
                                                        @Header("Authorization") @NonNull final String token,
                                                        @Body ProjectScopeToAssessmentBody requestBody);

    /**
     * Starts a new Assessment.
     */
    @POST("/pa/Commands/Assessment/StartNewAssessment")
    Call<BasicPostResponse> startNewAssessment(@Header("Content-Type") @NonNull final String contentType,
                                               @Header("Authorization") @NonNull final String token,
                                               @Body StartAssessmentBody startAssessmentBody);
    /**
     * Screen related
     */

    /**
     * Returns the activity stream of a given Contractor.
     */
    @POST("/Screen/Contractor/Stream")
    Call<BaseResponse<ContractorActivityStreamResponse>> getContractorActivityStream(@Header("Content-Type") @NonNull final String contentType,
                                                                                     @Header("Authorization") @NonNull final String token,
                                                                                     @Body ContractorActivityStreamBody requestBody);

    /**
     * Returns information about a Project and its Layout/Revisions.
     */
    @GET("/Screen/Contractor/ProjectInfoScreen")
    Call<BaseResponse<ProjectDetailsResponse>> getProjectDetails(@Header("Content-Type") @NonNull final String contentType,
                                                                 @Header("Authorization") @NonNull final String token,
                                                                 @Query("projectId") @NonNull final String projectId);

    /**
     * Returns detailed information about /Jobs/Layouts/PropertyJobs for the contractor requesting the data
     */
    @GET("/pa/Screen/Contractor/JobInfo")
    Call<BaseResponse<PropertyJobsDetailsResponse>> getPropertyJobsDetails(@Header("Content-Type") @NonNull final String contentType,
                                                                           @Header("Authorization") @NonNull final String token);

    /**
     * Returns the activity stream for a Point.
     */
    @POST("/Screen/Contractor/ActivityStream")
    Call<BaseResponse<ContractorActivityStreamResponse>> getContractorActivityStreamForAJob(@Header("Content-Type") @NonNull final String contentType,
                                                                                            @Header("Authorization") @NonNull final String token,
                                                                                            @Body ContractorActivityStreamBody requestBody);

    /**
     * Returns detailed information about a Point by given Project Id and Layout Id.
     */
    @GET("/Screen/Contractor/PoiDetailScreen")
    Call<BaseResponse<PointDetailsResponse>> getPointDetails(@Header("Content-Type") @NonNull final String contentType,
                                                             @Header("Authorization") @NonNull final String token,
                                                             @Query("projectId") @NonNull final String projectId,
                                                             @Query("layoutId") @NonNull final String layoutId);

    /**
     * Query related
     */

    /**
     * Returns a list of Work(s) in a DetailedJob.
     */
    @GET("/pa/Query/Contractor/DetailedJob/Work")
    Call<BaseResponse<WorkInADetailedJobResponse>> getWorkInAJob(@Header("Content-Type") @NonNull final String contentType,
                                                                 @Header("Authorization") @NonNull final String token,
                                                                 @Query("jobId") @NonNull final String jobId,
                                                                 @Query("layoutId") @Nullable final String layoutId);

    /**
     * Returns a {@link WorkInfoResponse} which is essentially a {@link DetailedJob}  with {@link com.mentormate.tcos.network.model.WorkList}
     */
    @GET("/pa/Query/Contractor/DetailedJob/Work/Info")
    Call<BaseResponse<WorkInfoResponse>> getWorkInfo(@Header("Content-Type") @NonNull final String contentType,
                                                     @Header("Authorization") @NonNull final String token,
                                                     @Query("workId") @NonNull final String workId);

    /**
     * Gets bid request(s) details
     */

    @GET("/pa/Query/Contractor/BidRequests")
    Call<BaseResponse<BidRequestsDetailsResponse>> getBidRequestsDetails(@Header("Content-Type") @NonNull final String contentType,
                                                                         @Header("Authorization") @NonNull final String token,
                                                                         @Query("size") final int size,
                                                                         @Query("from") final int from,
                                                                         @Query("bidRequests") @NonNull final List<String> ids);

    /**
     * Returns a list of Points in a bid request.
     */
    @GET("/pa/Query/Contractor/BidRequests/Scope")
    Call<BaseResponse<BidRequestPointsResponse>> getBidRequestPoints(@Header("Content-Type") @NonNull final String contentType,
                                                                     @Header("Authorization") @NonNull final String token,
                                                                     @Query("bidRequestId") @NonNull final String bidRequestId);

    /**
     * Returns detailed information about a DetailedJob.
     */
    @GET("/pa/Query/Contractor/DetailedJob/Info")
    Call<BaseResponse<DetailedJob>> getJobDetails(@Header("Content-Type") @NonNull final String contentType,
                                                  @Header("Authorization") @NonNull final String token,
                                                  @Query("jobId") @NonNull final String jobId);

    /**
     * Returns a detailed information about assigned detailedJobs to the current requesting contractor
     */
    @GET("/pa/Query/Contractor/DetailedJob")
    Call<BaseResponse<ContractorJobsResponse>> getContractorJobs(@Header("Content-Type") @NonNull final String contentType,
                                                                 @Header("Authorization") @NonNull final String token);

    /**
     * Gets bid request from an assessment with the assessment.
     */
    @GET("/pa/Query/PropertyManager/BidRequests/GetByAssessment")
    Call<BaseResponse<DetailedBidRequest>> getBidRequest(@Header("Content-Type") @NonNull final String contentType,
                                                         @Header("Authorization") @NonNull final String token,
                                                         @Query("assessmentId") @NonNull final String assessmentId);
}
