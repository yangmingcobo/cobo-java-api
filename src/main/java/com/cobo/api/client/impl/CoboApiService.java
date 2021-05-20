package com.cobo.api.client.impl;

import com.cobo.api.client.domain.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CoboApiService {
    @GET("/v1/custody/org_info/")
    Call<ApiResponse<OrgInfo>> getOrgInfo();

    @GET("/v1/custody/coin_info/")
    Call<ApiResponse<CoinInfo>> getCoinInfo(@Query("coin") String coin);

    @FormUrlEncoded
    @POST("/v1/custody/new_address/")
    Call<ApiResponse<Address>> newAddress(@Field("coin") String coin,
                                          @Field("native_segwit") boolean native_segwit);

    @FormUrlEncoded
    @POST("/v1/custody/new_address/")
    Call<ApiResponse<Address>> newAddress(@Field("coin") String coin);

    @FormUrlEncoded
    @POST("/v1/custody/new_addresses/")
    Call<ApiResponse<NewAddresses>> newAddresses(@Field("coin") String coin,
                                                 @Field("count") int count,
                                                 @Field("native_segwit") boolean native_segwit);

    @FormUrlEncoded
    @POST("/v1/custody/new_addresses/")
    Call<ApiResponse<NewAddresses>> newAddresses(@Field("coin") String coin,
                                                 @Field("count") int count);

    @GET("/v1/custody/address_info/")
    Call<ApiResponse<Address>> addressInfo(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/addresses_info/")
    Call<ApiResponse<Addresses>> addressesInfo(@Query("coin") String coin, @Query("address") String addresses);

    @GET("/v1/custody/is_valid_address/")
    Call<ApiResponse<Boolean>> isValidAddress(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/address_history/")
    Call<ApiResponse<List<Address>>> getAddressHistory(@Query("coin") String coin);

    @GET("/v1/custody/internal_address_info/")
    Call<ApiResponse<InternalAddressInfo>> getInternalAddressInfo(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/internal_address_info_batch/")
    Call<ApiResponse<List<InternalAddressInfo>>> getInternalAddressInfoBatch(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/transaction/")
    Call<ApiResponse<Transaction>> getTransactionById(@Query("id") String id);

    @GET("/v1/custody/transactions_by_id/")
    Call<ApiResponse<List<Transaction>>> getTransactionsById(@Query("coin") String coin, @Query("side") String side,
                                                             @Query("address") String address, @Query("max_id") String max_id,
                                                             @Query("min_id") String min_id, @Query("limit") int limit, @Query("include_financial") String include_financial);

    @GET("/v1/custody/transactions_by_time/")
    Call<ApiResponse<List<Transaction>>> getTransactionsByTime(@Query("coin") String coin, @Query("side") String side,
                                                               @Query("address") String address, @Query("begin_time") String beginTime,
                                                               @Query("end_time") String endTime, @Query("limit") String limit,
                                                               @Query("include_financial") String include_financial);

    //@GET("/v1/custody/transactions_by_time/")
    //Call<Response<List<Transaction>>> getTransactionsByTime(@QueryMap Map<String, Object> map);
    @GET("/v1/custody/pending_transactions/")
    Call<ApiResponse<List<Transaction>>> getPendingTransactions(@Query("coin") String coin, @Query("side") String side,
                                                                @Query("max_id") String max_id,
                                                                @Query("min_id") String min_id, @Query("limit") String limit);

    @GET("/v1/custody/pending_transaction/")
    Call<ApiResponse<Transaction>> getPendingTransaction(@Query("id") String id);

    @GET("/v1/custody/transaction_history/")
    Call<ApiResponse<List<Transaction>>> getTransactionHistory(@Query("coin") String coin, @Query("side") String side,
                                                               @Query("address") String address, @Query("max_id") String max_id,
                                                               @Query("min_id") String min_id, @Query("limit") String limit, @Query("begin_time") String beginTime,
                                                               @Query("end_time") String endTime, @Query("include_financial") String include_financial);

    @POST("/v1/custody/new_withdraw_request/")
    Call<ApiResponse<String>> withdraw(@Query("coin") String coin,
                                       @Query("request_id") String requestId, @Query("address") String address,
                                       @Query("amount") String amount, @Query("memo") String memo,
                                       @Query("force_external") String force_external, @Query("force_internal") String force_internal);

    @GET("/v1/custody/withdraw_info_by_request_id/")
    Call<ApiResponse<Transaction>> queryWithdrawInfo(@Query("request_id") String requestId);

    @GET("/v1/custody/staking_products/")
    Call<ApiResponse<List<StakingProduct>>> getStakingProducts(@Query("coin") String coin, @Query("language") String lang);

    @GET("/v1/custody/staking_product/")
    Call<ApiResponse<StakingProduct>> getStakingProductById(@Query("product_id") String coin, @Query("language") String lang);

    @GET("/v1/custody/stakings/")
    Call<ApiResponse<List<StakingProduct>>> getStakings(@Query("coin") String coin, @Query("language") String lang);
    @GET("/v1/custody/unstakings/")
    Call<ApiResponse<List<Unstaking>>> getUnstakings(@Query("coin") String coin, @Query("language") String lang);

    @GET("/v1/custody/staking_history/")
    Call<ApiResponse<List<StakingHistory>>> getStakingHistory(@Query("coin") String coin, @Query("type") String type,
                                                              @Query("max_id") String maxId, @Query("limit") String limit,
                                                              @Query("product_id") String productId);
    @POST("/v1/custody/staking_stake/")
    Call<ApiResponse<Void>> stake(@Field("product_id") String productId, @Field("amount") String amount);

    @POST("/v1/custody/staking_stake/")
    Call<ApiResponse<Void>> unstake(@Field("product_id") String productId, @Field("amount") String amount);

}
