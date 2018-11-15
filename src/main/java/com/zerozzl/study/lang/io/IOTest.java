package com.zerozzl.study.lang.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import com.zerozzl.study.model.User;

public class IOTest {

	public static void fileInputStreamTest(String fileName) {
		StringBuilder builder = new StringBuilder("");
		FileInputStream in = null;
		try {
			in = new FileInputStream(fileName);
			int length;
			byte[] buf = new byte[1024];
			while ((length = in.read(buf)) != -1) {
				builder.append(new String(buf, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(builder.toString());
	}

	public static void fileOutputStreamTest(String fileName) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			String str = "Hello World\n";
			byte[] b = str.getBytes();
			out.write("write by FileOutputStream\n".getBytes());
			out.write(b);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void bufferedInputStreamTest(String fileName) {
		StringBuilder builder = new StringBuilder("");
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(fileName));
			int length;
			byte[] buf = new byte[1024];
			while ((length = in.read(buf)) != -1) {
				builder.append(new String(buf, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(builder.toString());
	}

	public static void bufferedOutputStreamTest(String fileName) {
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(fileName, true));
			String str = "Hello World\n";
			byte[] b = str.getBytes();
			out.write("write by BufferedOutputStream\n".getBytes());
			out.write(b);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void fileReaderTest(String fileName) {
		StringBuilder builder = new StringBuilder("");
		FileReader read = null;
		try {
			read = new FileReader(fileName);
			int length = 0;
			char[] buf = new char[100];
			while ((length = read.read(buf)) != -1) {
				builder.append(new String(buf, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(builder.toString());
	}

	public static void fileWriterTest(String fileName) {
		FileWriter out = null;
		try {
			out = new FileWriter(fileName, true);
			String str = "Hello World\n";
			out.write("write by FileWriter\n");
			out.write(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void bufferedReaderTest(String fileName) {
		StringBuilder builder = new StringBuilder("");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader((fileName)));
			String content = null;
			while ((content = reader.readLine()) != null) {
				builder.append(content + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("你输入的内容是：" + builder.toString());
	}

	public static void bufferedWriterTest(String fileName) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(fileName, true));
			String str = "Hello World\n";
			out.write("write by BufferedWriter\n");
			out.write(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void inputStreamReaderTest(String fileName) {
		StringBuilder builder = new StringBuilder("");
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(fileName), "utf-8");
			int length = 0;
			char[] buf = new char[100];
			while ((length = reader.read(buf)) != -1) {
				builder.append(new String(buf, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("你输入的内容是：" + builder.toString());
	}

	public static void outputStreamWriterTest(String fileName) {
		OutputStreamWriter out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(fileName, true), "utf-8");
			String str = "Hello World\n";
			out.write("write by OutputStreamWriter\n");
			out.write(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void byteArrayStreamTest() throws IOException {
		String str = "zhangbin";
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes("UTF-16"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int length;
		byte[] buf = new byte[1024];
		while ((length = bais.read(buf)) != -1) {
			baos.write(buf, 0, length);
		}

		System.out.println("UTF-8结果: " + baos.toString()); // 默认编码UTF-8
		System.out.println("UTF-16结果: " + baos.toString("UTF-16"));
	}

	public static void dataStreamTest(String filename) throws IOException {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(filename));
			// 给流中写入数据
			dos.writeInt(10);
			dos.writeShort(100);
			dos.writeByte(120);
			dos.writeDouble(13.34);
			dos.writeFloat(12.56F);
			dos.writeBoolean(true);
			dos.writeChar('a');
			dos.writeUTF("test123");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(filename));
			int i = dis.readInt();
			short s = dis.readShort();
			byte b = dis.readByte();
			double d = dis.readDouble();
			float f = dis.readFloat();
			boolean flag = dis.readBoolean();
			char ch = dis.readChar();
			String str = dis.readUTF();

			System.out.println(i);
			System.out.println(s);
			System.out.println(b);
			System.out.println(d);
			System.out.println(f);
			System.out.println(flag);
			System.out.println(ch);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void objectStreamTest(String filename) throws IOException {
		ObjectOutputStream output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(filename));
			output.writeObject(new User(1, "test", 123));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(new FileInputStream(filename));
			User object = (User) input.readObject();
			System.out.println(object.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String fileInName = "D:/test.txt", fileOutName = "D:/test_out.txt", fileDate = "D:/test_data.txt",
				fileObject = "D:/test_object.txt";
		System.out.println("============== fileInputStreamTest ===============");
		fileInputStreamTest(fileInName);
		System.out.println("============== fileOutputStreamTest ===============");
		fileOutputStreamTest(fileOutName);

		System.out.println("============== bufferedInputStreamTest ===============");
		bufferedInputStreamTest(fileInName);
		System.out.println("============== bufferedOutputStreamTest ===============");
		bufferedOutputStreamTest(fileOutName);

		System.out.println("============== fileReaderTest ===============");
		fileReaderTest(fileInName);
		System.out.println("============== fileWriterTest ===============");
		fileWriterTest(fileOutName);

		System.out.println("============== bufferedReaderTest ===============");
		bufferedReaderTest(fileInName);
		System.out.println("============== bufferedWriterTest ===============");
		bufferedWriterTest(fileOutName);

		System.out.println("============== inputStreamReaderTest ===============");
		inputStreamReaderTest(fileInName);
		System.out.println("============== outputStreamWriterTest ===============");
		outputStreamWriterTest(fileOutName);

		System.out.println("============== byteArrayStreamTest ===============");
		byteArrayStreamTest();

		System.out.println("============== dataStreamTest ===============");
		dataStreamTest(fileDate);

		System.out.println("============== objectStreamTest ===============");
		objectStreamTest(fileObject);
	}

}
