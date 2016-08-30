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

import com.aaa.chat.view.CameraSurfaceView;

import android.app.Activity;
import android.os.Bundle;

public class CameraActivity extends Activity
{
	CameraSurfaceView csv;
//sda
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		initView();
	}

	private void initView()
	{
		csv=(CameraSurfaceView)findViewById(R.id.csv_surface);
	}
}
