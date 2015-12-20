package com.consultorio.core.entity.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.consultorio.core.dataaccess.entity.Patient;

public class FormsTest {
	@Test
	public void getFields(){
		getFormConfig(Patient.class);
		
	}
	
	/*
	 * {
          key: 'email',
          type: 'input',
          templateOptions: {
            type: 'email',
            label: 'Email address',
            placeholder: 'Enter email'
          }
        },
	 */
	
	public List<Map<String,String>> getFormConfig(Class<?> yourClass){
		System.err.println("Entering "+yourClass);
		Class<?> current = yourClass;
		List<Map<String,String>> fieldset = new ArrayList<Map<String,String>>();
		
		Map<String,String> config = new HashMap<String,String>();
		
		for(Field f : current.getDeclaredFields()){
			System.out.println(f.getName()+": "+BeanUtils.isSimpleValueType(f.getType()));
			
			if(!BeanUtils.isSimpleValueType(f.getType())){
				 getFormConfig(f.getType());
			}
	    }
		while(current.getSuperclass()!=null){ // we don't want to process Object.class
		    // do something with current's fields
		    current = current.getSuperclass();
		    for(Field f : current.getDeclaredFields()){
		    	System.out.println(f.getName()+": "+BeanUtils.isSimpleValueType(f.getType()));
		    	if(!BeanUtils.isSimpleValueType(f.getType())){
					 getFormConfig(f.getType());
				}
		    }
		}
		return fieldset;
	}
	
	

}
