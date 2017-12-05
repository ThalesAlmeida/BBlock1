/********************************************
 Class: AGNioBuffer
 Description: used to create a NioBuffer
 Author: Silvano Maneck Malfatti
 Date: 05/11/2013
 ********************************************/

//Engine Package
package br.com.hellmets.motocerol.AndGraph;

//Used packages
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class AGNioBuffer
{
	/********************************************
	* Name: generateNioBuffer()
	* Description: used to generate a FloatBuffer object
	* Parameters: float[]
	* Returns: FloatBuffer
	******************************************/
	public static FloatBuffer criaBuffer(float[] array)
	{
		//Alloc Bytes in memory
		ByteBuffer vrByteBuffer = ByteBuffer.allocateDirect(array.length * 4);
		vrByteBuffer.order(ByteOrder.nativeOrder());
				
		//Create a FloatBuffer
		FloatBuffer vrFloatBuffer = vrByteBuffer.asFloatBuffer();
		vrFloatBuffer.clear();	
							
		//Insert a Java Array into Float Buffer
		vrFloatBuffer.put(array);
				
		//Reset FloatBuffer attribs
		vrFloatBuffer.flip();
		
		return vrFloatBuffer;
	}
}
