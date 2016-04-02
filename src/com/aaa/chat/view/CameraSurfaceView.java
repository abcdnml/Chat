/*   
 * Copyright (c) 2013-2020 Founder Ltd. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */

package com.aaa.chat.view;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraSurfaceView extends SurfaceView implements PictureCallback, PreviewCallback, SurfaceHolder.Callback
{

	private Camera camera;
	private SurfaceHolder mHolder;
	private int rotate = 90;

	public CameraSurfaceView(Context context)
	{
		super(context);

	}

	public CameraSurfaceView(Context context,AttributeSet attrs)
	{
		super(context,attrs);
		mHolder = getHolder();
		mHolder.addCallback(this);
	}

	public CameraSurfaceView(Context context,AttributeSet attrs,int defStyle)
	{
		super(context,attrs,defStyle);
	}

	private void openCamera()
	{
		try
		{

			camera = Camera.open();
			camera.setDisplayOrientation(rotate);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void openCamera(int facing)
	{
		try
		{
			camera = Camera.open(getCameraId(facing));
			camera.setDisplayOrientation(rotate);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public int getCameraId(int facing)
	{
		CameraInfo ci = new CameraInfo();
		for(int i = 0,num = Camera.getNumberOfCameras(); i < num; i++)
		{
			Camera.getCameraInfo(i,ci);
			if(ci.facing == facing)
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * surfaceHolder回调
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		openCamera();
		try
		{
			camera.setPreviewDisplay(holder);
			camera.setPreviewCallbackWithBuffer(this);
			camera.startPreview();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		mHolder=holder;
		if(holder.getSurface() == null)
		{
			return;
		}

		camera.stopPreview();

		try
		{
			camera.setPreviewDisplay(holder);
			camera.setPreviewCallbackWithBuffer(this);
			camera.startPreview();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		camera.setPreviewCallback(null); //！！这个必须在前，不然退出出错
		camera.stopPreview();
		camera.release();
	}

	/**
	 * 拍照回调
	 */
	@Override
	public void onPictureTaken(byte[] data, Camera camera)
	{

	}

	/**
	 * 预览回调
	 */
	@Override
	public void onPreviewFrame(byte[] data, Camera camera)
	{
		Log.i("preview","data size : " + data.length);
	}

}
