package com.example.seznamnakup;

private void Refresh() 
{
	lv = findViewById(R.id.listview_seznam);
	lv.setAdapter(new MyListAdapter(this,R.layout.layout_custom,zbozis));
}
public class ViewHolder{
        TextView text;
        ImageButton button;
}
private class MyListAdapter extends ArrayAdapter<String>{
    private int layout;
    private List<Zbozi> objects;
    public MyListAdapter(Context context, int resource, List<Zbozi> objects) {
        super(context, resource);
        this.objects = objects;
        layout=resource;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mainViewHolder = null;
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(layout,parent,false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text=(TextView) convertView.findViewById(R.id.textview_list_item);
            viewHolder.button=(ImageButton) convertView.findViewById(R.id.btn_list_item);
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"Tlačítko bylo zmáčknuté pro item: "+position, Toast.LENGTH_SHORT).show();
                }
            });
            convertView.setTag(viewHolder);

        }
        else{
            mainViewHolder=(ViewHolder)convertView.getTag();
            mainViewHolder.text.setText(getItem(position));
        }

        return convertView;
    }
}