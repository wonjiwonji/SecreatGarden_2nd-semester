package com.example.shingubotanic;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private ViewHolder viewHolder = null;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    //차일드 뷰 반환
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }


    //차일드 뷰 ID 반환
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //차일드 뷰 생성(각 차일드 뷰의 (ROW)
    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_course_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);

        return convertView;
    }

    //차일드 뷰의 사이즈 반환
    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    //그룹 포지션 반환
    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    //그룹 사이즈를 반환
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    //그룹 ID를 반환
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //그룹 뷰 생성(그룹 각 뷰의 ROW)
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_course_group, null);
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        //그룹을 펼칠 때 또는 닫을 때 아이콘 변경
        if(isExpanded){
            viewHolder.iv_image.setImageResource(R.drawable.green_tri);
//            viewHolder.iv_image.setBackgroundColor(Color.GREEN);
        }else{
            viewHolder.iv_image.setImageResource(R.drawable.gray_tri);
//            viewHolder.iv_image.setBackgroundColor(Color.WHITE);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    //뷰홀더 클래스 생성
    class ViewHolder {
        public ImageView iv_image;
    }

}

