package com.zerozzl.study.lang;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiskClassLoader extends ClassLoader {

	private String mLibPath;

	public DiskClassLoader(
			String path) {
		mLibPath = path;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		File file = new File(mLibPath, fileName);
		try {
			FileInputStream is = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			try {
				while ((len = is.read()) != -1) {
					bos.write(len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			byte[] data = bos.toByteArray();
			is.close();
			bos.close();

			return defineClass(name, data, 0, data.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}

	// 获取要加载 的class文件名
	private String getFileName(String name) {
		int index = name.lastIndexOf('.');
		if (index == -1) {
			return name + ".class";
		} else {
			return name.substring(index + 1) + ".class";
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib");
		try {
			Class c = diskLoader.loadClass("com.frank.test.Test");
			if (c != null) {
				try {
					Object obj = c.newInstance();
					Method method = c.getDeclaredMethod("say", null);
					// 通过反射调用Test类的say方法
					method.invoke(obj, null);
				} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
						| IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
