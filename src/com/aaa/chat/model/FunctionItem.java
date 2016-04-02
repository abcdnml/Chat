/*   
 * Copyright (c) 2013-2020 Founder Ltd. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */

package com.aaa.chat.model;

import android.content.Intent;

public class FunctionItem
{
	private String name;
	private Intent intent;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Intent getIntent()
	{
		return intent;
	}

	public void setIntent(Intent intent)
	{
		this.intent = intent;
	}
}
