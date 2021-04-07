package rpc;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import entity.Item;
import entity.Item.ItemBuilder;

public class RpcHelperTest {

	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		ItemBuilder one = new ItemBuilder();
		one.setItemId("one");
		one.setCategories(category);
		one.setDistance(5);
		one.setRating(3);
		ItemBuilder two = new ItemBuilder();
		two.setItemId("two");
		two.setCategories(category);
		two.setDistance(5);
		two.setRating(3);
		List<Item> listItem = new ArrayList<Item>();
		listItem.add(one.build());
		listItem.add(two.build());
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.build().toJSONObject());
		jsonArray.put(two.build().toJSONObject());
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}
	
//	@Test
//	public void testGetJSONArrayCornerCases() throws JSONException {
//		Set<String> category = new HashSet<String>();
//		category.add("category one");
//		List<Item> listItem = new ArrayList<Item>();
//		JSONArray jsonArray = new JSONArray();
//		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
//		ItemBuilder one = new ItemBuilder();
//		one.setItemId("one");
//		one.setCategories(category);
//		one.setDistance(5);
//		one.setRating(3);
//		ItemBuilder two = new ItemBuilder();
//		two.setItemId("two");
//		two.setCategories(category);
//		two.setDistance(5);
//		two.setRating(3);
//		listItem.add(one.build());
//		listItem.add(two.build());
//		jsonArray.put(one.build().toJSONObject());
//		jsonArray.put(two.build().toJSONObject());
//		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
//		Item empty = new ItemBuilder().build();
//		jsonArray.put(empty.toJSONObject());
//		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
//	}
}
