package com.retail.shop.retailShop.model;

import java.util.Date;

public class Retail {
    private int id;
    private String user;
    private String desc;
    private int price;
    

    @Override
	public String toString() {
		return "Retail [id=" + id + ", user=" + user + ", desc=" + desc + ", price=" + price + "]";
	}

	public Retail(int id, String user, String desc, int price) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.price = price;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Retail other = (Retail) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

   
}