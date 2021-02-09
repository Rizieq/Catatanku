package com.rizieq.catatanku;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangView> {

    private Context context;
    private Cursor cursor;

    public BarangAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }


    @NonNull
    @Override
    public BarangAdapter.BarangView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BarangView(LayoutInflater.from(context).inflate(R.layout.barang_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.BarangView barangView, int i) {

        if (!cursor.moveToPosition(i)){
            return;
        }

        String name = cursor.getString(cursor.getColumnIndex(BarangContract.BarangEntry.COLUMN_NAME));
        int amount = cursor.getInt(cursor.getColumnIndex(BarangContract.BarangEntry.COLUMN_AMOUNT));
        long id = cursor.getLong(cursor.getColumnIndex(BarangContract.BarangEntry._ID));

        barangView.nameText.setText(name);
        barangView.countText.setText(String.valueOf(amount));
        barangView.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if (cursor != null){
            cursor.close();
        }

        cursor = newCursor;
        if (newCursor != null){
            notifyDataSetChanged();
        }
    }

    public class BarangView extends RecyclerView.ViewHolder {

        public TextView nameText, countText;

        public BarangView(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.textview_name_item);
            countText = itemView.findViewById(R.id.textview_amount_item);

        }
    }
}
