/*   
 * Copyright (c) 2013-2020 Founder Ltd. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */

package com.aaa.chat;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraSurfaceView extends SurfaceView implements PictureCallback,PreviewCallback,SurfaceHolder.Callback
{

	//
	public CameraSurfaceView(Context context)
	{
		super(context);
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
		
	}


	/**
	 * surfaceHolder回调
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
	}

}
