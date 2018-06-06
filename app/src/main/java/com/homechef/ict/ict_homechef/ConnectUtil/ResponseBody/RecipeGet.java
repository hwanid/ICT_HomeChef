package com.homechef.ict.ict_homechef.ConnectUtil.ResponseBody;

public class RecipeGet {

    public final int recipe_id;
    public final String title;
    public final String serve;
    public final String ingre_count;
    public final String steps;
    public final String time_cost;
    public final String image_url;
    public final int author_id;
    public final int recommend_count;
    public final String created_at;
    public final String updated_at;
    public final String author_name;

    public RecipeGet(int recipe_id, String title, String serve, String ingre_count,
                      String steps, String time_cost, String image_url, int author_id,
                      int recommend_count, String created_at, String updated_at,
                     String author_name) {

        this.recipe_id = recipe_id;
        this.title = title;
        this.serve = serve;
        this.ingre_count = ingre_count;
        this.steps = steps;
        this.time_cost = time_cost;
        this.image_url = image_url;
        this.author_id = author_id;
        this.recommend_count = recommend_count;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.author_name = author_name;

    }
}
