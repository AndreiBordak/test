package com.epam.json.utils;

import org.apache.log4j.Logger;

public class ObjectFactory {

	private static final Logger LOGGER = Logger.getLogger(ObjectFactory.class);

	public static <T> T createInstance(Class<T> clazz) {
		T object = null;
		try {
			object = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			LOGGER.error(
					"Cannot create an instance of class" + clazz.getName(), e);
		}

		return object;
	}
}
