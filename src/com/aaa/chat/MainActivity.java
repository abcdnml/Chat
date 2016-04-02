package com.aaa.chat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.aaa.chat.model.FunctionItem;

public class MainActivity extends Activity
{

	TextView tv_title;
	GridView gv_function;
	List<FunctionItem> lfi;
	FunctionAdapter fa;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initFunctionList();
		initView();
	}

	private void initView()
	{
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText(R.string.function_list);
		gv_function = (GridView) findViewById(R.id.gv_function);
		gv_function.setAdapter(fa);
		gv_function.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				startActivity(lfi.get(position).getIntent());
			}
		});
	}

	private void initFunctionList()
	{
		lfi = new ArrayList<FunctionItem>();
		
		FunctionItem fi=new FunctionItem();
		fi.setName(getString(R.string.function_camera));
		fi.setIntent(new Intent(this,CameraActivity.class));
		lfi.add(fi);
		fa = new FunctionAdapter();
	}

	class FunctionAdapter extends BaseAdapter
	{

		@Override
		public int getCount()
		{
			return lfi.size();
		}

		@Override
		public Object getItem(int position)
		{
			return lfi.get(position);
		}

		@Override
		public long getItemId(int position)
		{
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			ViewHolder holder = null;
			if(convertView == null)
			{
				holder = new ViewHolder();
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.grid_item_function,null);
				holder.tv_name = (TextView) convertView.findViewById(R.id.item_function_name);
				convertView.setTag(holder);
			}
			else
			{
				holder = (ViewHolder) convertView.getTag();
			}
			holder.tv_name.setText(lfi.get(position).getName());
			return convertView;
		}

		class ViewHolder
		{
			TextView tv_name;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		if(id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
