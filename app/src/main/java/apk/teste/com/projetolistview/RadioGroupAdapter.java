package apk.teste.com.projetolistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

/**
 * Created by mario on 29/10/2015.
 */
public class RadioGroupAdapter extends ArrayAdapter<Option> {

    Context context;
    int layoutResourceId;
    Option data[] = null;

    public RadioGroupAdapter(Context context, int layoutResourceId,
                             Option[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MatrixHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new MatrixHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.heading);
            holder.group = (RadioGroup) row.findViewById(R.id.radio_group1);
            final String[] nivel = {"Baixa","Média","Alta"};

            final RadioButton[] rb = new RadioButton[5];

            for(int i=0; i<3; i++){

                rb[i]  = new RadioButton(context);
                rb[i].setText(nivel[i]);
                //rb[i].setButtonDrawable(R.drawable.single_radio_chice);
                rb[i].setId(i);
                RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                        0, LayoutParams.WRAP_CONTENT);
                params.weight=1.0f;
                params.setMargins(15, 0, 5, 10);
                holder.group.addView(rb[i],params); //the RadioButtons are added to the radioGroup instead of the layout
            }
            row.setTag(holder);
        } else {
            holder = (MatrixHolder) row.getTag();
        }

        Option option = data[position];
        holder.txtTitle.setText(option.title);
        return row;
    }

    static class MatrixHolder {
        TextView txtTitle;
        RadioGroup group;
        int position;
    }
}
