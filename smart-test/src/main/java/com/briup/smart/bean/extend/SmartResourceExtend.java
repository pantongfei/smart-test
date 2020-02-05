package com.briup.smart.bean.extend;

import java.util.List;

import com.briup.smart.bean.SmartResource;

public class SmartResourceExtend extends SmartResource{
	private List<SmartResource> subResource;

	public List<SmartResource> getSubResource() {
		return subResource;
	}

	public void setSubResource(List<SmartResource> subResource) {
		this.subResource = subResource;
	}
	
	 
}
