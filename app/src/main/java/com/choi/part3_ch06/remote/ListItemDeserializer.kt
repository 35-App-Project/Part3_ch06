package com.choi.part3_ch06.remote

import com.choi.part3_ch06.model.Coupon
import com.choi.part3_ch06.model.Empty
import com.choi.part3_ch06.model.FullAd
import com.choi.part3_ch06.model.Horiziontal
import com.choi.part3_ch06.model.Image
import com.choi.part3_ch06.model.ListItem
import com.choi.part3_ch06.model.Sale
import com.choi.part3_ch06.model.SellItem
import com.choi.part3_ch06.model.ViewPager
import com.choi.part3_ch06.model.ViewType
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

// 역 직렬화
class ListItemDeserializer :  JsonDeserializer<ListItem> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ListItem {

        val viewTypeName = json.asJsonObject.getAsJsonPrimitive("viewType").asString
        // gson 을 받아와야 한다 (ListItem 안에 또 다른 ListItem 이 있어서?)
        val gson = GsonBuilder()
            .registerTypeAdapter(ListItem::class.java, ListItemDeserializer())
            .create()

        return try {
            when(viewTypeName) {
                ViewType.VIEW_PAGER.name-> gson.fromJson(json, ViewPager::class.java)
                ViewType.HORIZONTAL.name-> gson.fromJson(json, Horiziontal::class.java)
                ViewType.FULL_AD.name-> gson.fromJson(json, FullAd::class.java)

                ViewType.SELL_ITEM.name -> gson.fromJson(json, SellItem::class.java)
                ViewType.IMAGE.name -> gson.fromJson(json, Image::class.java)
                ViewType.SALE.name -> gson.fromJson(json, Sale::class.java)
                ViewType.COUPON.name -> gson.fromJson(json, Coupon::class.java)

                else-> gson.fromJson(json,Empty::class.java)
            }

        } catch (e:Exception) {
            gson.fromJson(json,Empty::class.java)
        }

    }
}