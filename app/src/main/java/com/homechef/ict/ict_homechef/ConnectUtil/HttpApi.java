package com.homechef.ict.ict_homechef.ConnectUtil;

import com.homechef.ict.ict_homechef.ConnectUtil.RequestBody.LoginPut;
import com.homechef.ict.ict_homechef.ConnectUtil.RequestBody.RecipePut;
import com.homechef.ict.ict_homechef.ConnectUtil.RequestBody.SessionPut;
import com.homechef.ict.ict_homechef.ConnectUtil.ResponseBody.PostRecipeGet;
import com.homechef.ict.ict_homechef.ConnectUtil.ResponseBody.RecipeGet;
import com.homechef.ict.ict_homechef.ConnectUtil.ResponseBody.RecipeListGet;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


/*

읽는법

    @통신방식(추가URL)
    Call<결과값 방식 (= ResponseBody 폴더 안의 데이터구조 방식)> 함수이름(@전송형태 전송하는정보들)

ex)
    @POST("/api/recipes")
    Call<PostRecipe> postRecipe(@Body RecipePut parameters);



@통신방식에 대해

    @Path는 추가URL에 추가적으로 URL을 덧붙히는것
    @Body는 서버에 보내는 json 데이터구조 자체 정보 RequestBody 폴더에서 구조들 확인 가능
    @Query는 Url에 쿼리문 추가해줌
    @Header는 헤더 추가


최종 결과값에 대해

    Call<결과값 방식>  ~~~   에서
    1. 결과값 방식 == ResponseBody 일 경우 결과값은 String
    2. 그 외의 경우에는 "결과값방식" 자체가 structure 가 되어,
       결과값방식.keyName 형태로 사용할 수 있다.

    ex)
    public void onSuccess(int code, Object receivedData) {
        PostRecipe data = (PostRecipe) receivedData;
    }
    에서
    int IdForRecipe = data.recipe_id 꼴로 사용해서
    recipe_id를 받을 수 있음


 */

public interface HttpApi {

    final String Base_URL = "http://13.124.27.141:80";

    // 제작완료

    // 레시피 등록
    @POST("/api/recipes")
    Call<PostRecipeGet> postRecipe(@HeaderMap Map<String,String> headers, @Body RecipePut parameters);

    // 로그인
    @POST("/auth/login")
    Call<ResponseBody> postLogin(@Body LoginPut parameters);

    // token 갱신
    @POST("/auth/sessions")
    Call<ResponseBody> postSession(@Body SessionPut jwt_token);

    // 레시피 id로 얻기
    @GET("/api/recipes/{recipe_id}")
    Call<RecipeGet> getRecipe(@HeaderMap Map<String, String> headers, @Path("recipe_id") String id);

    // 레시피 리스트 query로 얻기
    @GET("/api/recipes")
    Call<List<RecipeListGet>> getRecipeList(@HeaderMap Map<String, String> headers,
                                            @Query("contain") String contain,
                                            @Query("offset") String offset,
                                            @Query("limit") String limit,
                                            @Query("except") String except);

    @PUT("/api/recipes/{recipe_id}")
    Call<RecipeGet> putRecipe(@HeaderMap Map<String,String> headers, @Path("recipe_id") String id);


    @DELETE("/api/recipes/{recipe_id}")
    Call<ResponseBody> deleteRecipe(@HeaderMap Map<String,String> headers, @Path("recipe_id") int id);



}
