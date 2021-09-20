package com.testing.task.mvvm.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose





  class User {
      @SerializedName("drinks")
      @Expose
      private var drinks: ArrayList<Drink?>? = null

      fun getDrinks(): ArrayList<Drink?>? {
          return drinks
      }

      fun setDrinks(drinks: ArrayList<Drink?>?) {
          this.drinks = drinks
      }
  }

class Drink {
    @SerializedName("idDrink")
    @Expose
    var idDrink: String? = null

    @SerializedName("strDrink")
    @Expose
    var strDrink: String? = null

    @SerializedName("strDrinkAlternate")
    @Expose
    var strDrinkAlternate: Any? = null

    @SerializedName("strTags")
    @Expose
    var strTags: String? = null

    @SerializedName("strVideo")
    @Expose
    var strVideo: Any? = null

    @SerializedName("strCategory")
    @Expose
    var strCategory: String? = null

    @SerializedName("strIBA")
    @Expose
    var strIBA: String? = null

    @SerializedName("strAlcoholic")
    @Expose
    var strAlcoholic: String? = null

    @SerializedName("strGlass")
    @Expose
    var strGlass: String? = null

    @SerializedName("strInstructions")
    @Expose
    var strInstructions: String? = null

    @SerializedName("strInstructionsES")
    @Expose
    var strInstructionsES: Any? = null

    @SerializedName("strInstructionsDE")
    @Expose
    var strInstructionsDE: String? = null

    @SerializedName("strInstructionsFR")
    @Expose
    var strInstructionsFR: Any? = null

    @SerializedName("strInstructionsIT")
    @Expose
    var strInstructionsIT: String? = null

    @SerializedName("strInstructionsZH-HANS")
    @Expose
    var strInstructionsZHHANS: Any? = null

    @SerializedName("strInstructionsZH-HANT")
    @Expose
    var strInstructionsZHHANT: Any? = null

    @SerializedName("strDrinkThumb")
    @Expose
    var strDrinkThumb: String? = null

    @SerializedName("strIngredient1")
    @Expose
    var strIngredient1: String? = null

    @SerializedName("strIngredient2")
    @Expose
    var strIngredient2: String? = null

    @SerializedName("strIngredient3")
    @Expose
    var strIngredient3: String? = null

    @SerializedName("strIngredient4")
    @Expose
    var strIngredient4: String? = null

    @SerializedName("strIngredient5")
    @Expose
    var strIngredient5: Any? = null

    @SerializedName("strIngredient6")
    @Expose
    var strIngredient6: Any? = null

    @SerializedName("strIngredient7")
    @Expose
    var strIngredient7: Any? = null

    @SerializedName("strIngredient8")
    @Expose
    var strIngredient8: Any? = null

    @SerializedName("strIngredient9")
    @Expose
    var strIngredient9: Any? = null

    @SerializedName("strIngredient10")
    @Expose
    var strIngredient10: Any? = null

    @SerializedName("strIngredient11")
    @Expose
    var strIngredient11: Any? = null

    @SerializedName("strIngredient12")
    @Expose
    var strIngredient12: Any? = null

    @SerializedName("strIngredient13")
    @Expose
    var strIngredient13: Any? = null

    @SerializedName("strIngredient14")
    @Expose
    var strIngredient14: Any? = null

    @SerializedName("strIngredient15")
    @Expose
    var strIngredient15: Any? = null

    @SerializedName("strMeasure1")
    @Expose
    var strMeasure1: String? = null

    @SerializedName("strMeasure2")
    @Expose
    var strMeasure2: String? = null

    @SerializedName("strMeasure3")
    @Expose
    var strMeasure3: String? = null

    @SerializedName("strMeasure4")
    @Expose
    var strMeasure4: Any? = null

    @SerializedName("strMeasure5")
    @Expose
    var strMeasure5: Any? = null

    @SerializedName("strMeasure6")
    @Expose
    var strMeasure6: Any? = null

    @SerializedName("strMeasure7")
    @Expose
    var strMeasure7: Any? = null

    @SerializedName("strMeasure8")
    @Expose
    var strMeasure8: Any? = null

    @SerializedName("strMeasure9")
    @Expose
    var strMeasure9: Any? = null

    @SerializedName("strMeasure10")
    @Expose
    var strMeasure10: Any? = null

    @SerializedName("strMeasure11")
    @Expose
    var strMeasure11: Any? = null

    @SerializedName("strMeasure12")
    @Expose
    var strMeasure12: Any? = null

    @SerializedName("strMeasure13")
    @Expose
    var strMeasure13: Any? = null

    @SerializedName("strMeasure14")
    @Expose
    var strMeasure14: Any? = null

    @SerializedName("strMeasure15")
    @Expose
    var strMeasure15: Any? = null

    @SerializedName("strImageSource")
    @Expose
    var strImageSource: String? = null

    @SerializedName("strImageAttribution")
    @Expose
    var strImageAttribution: String? = null

    @SerializedName("strCreativeCommonsConfirmed")
    @Expose
    var strCreativeCommonsConfirmed: String? = null

    @SerializedName("dateModified")
    @Expose
    var dateModified: String? = null
}