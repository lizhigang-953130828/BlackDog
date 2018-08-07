package com.lizhigang.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公用条件查询类
 */
public class Criteria implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 存放条件查询值
     */
    private Map<String, Object> condition;
    
    /**
     * 存放查询时多个条件，便于遍历
     */
    private List<String> conditionList; 


    protected Criteria(Criteria example) {
        this.condition = example.condition;
    }

    public Criteria() {
        condition = new HashMap<String, Object>();
        conditionList = new ArrayList<String>();
    }

    public void clear() {
        condition.clear();
        this.conditionList = null;
    }

    /**
     * @param key 查询的条件名称
	 * @param value 查询的值
     */
    public Criteria put(String key, Object value) {
        this.condition.put(key, value);
        return (Criteria) this;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }
	
	public void removeCondition(String key){
		if(condition.containsKey(key)){
			condition.remove(key);
		}
	}
}