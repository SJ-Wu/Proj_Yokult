package web.product.list.vo;



public class Shoppingcart {
//購物車項目內容

//@Data //get，set 方法

		
		private String skuId;//商品ID
		private Boolean check = true;//商品選項，有選到都是true
		private String title;//商品開頭
		private String image;//商品圖片
		private Integer price;//商品價格(有牽扯到計算需要使用Decimal)
		private Integer count;//商品數量
		private Integer totalPrice;//商品總價
		
		public String getSkuId() {
			return skuId;
		}
		public void setSkuId(String skuId) {
			this.skuId = skuId;
		}
		public Boolean getCheck() {
			return check;
		}
		public void setCheck(Boolean check) {
			this.check = check;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Integer getPrice() {
			return price;
		}
		public void setPrice(Integer price) {
			this.price = price;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Integer getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(Integer totalPrice) {
			this.totalPrice = totalPrice;
		}

//		//計算數量跟總價 
	//	
	//	
//			public BigDecimal getTotalPrice() {
//				
//				return this.price.multiply(new BigDecimal(""+this.count));
//			}
//			public void setTotalPrice(BigDecimal totalPrice) {
//				this.totalPrice = totalPrice;
//			}
			
		
		
	}

