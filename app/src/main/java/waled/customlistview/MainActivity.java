package waled.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<DepartmentAttribute> DepInfo;
    private void getDepInfo(){
        DepInfo.add(new DepartmentAttribute("Dep1", "20 Emp", "5 Emp On"));
        DepInfo.add(new DepartmentAttribute("Dep2", "30 Emp", "10 Emp On"));
        DepInfo.add(new DepartmentAttribute("Dep3 ", "40 Emp", "25 EmpOn"));
        DepInfo.add(new DepartmentAttribute("Dep4 ", "50 Emp", "35 EmpOn"));
        DepInfo.add(new DepartmentAttribute("Dep5 ", "60 Emp", "35 EmpOn"));
        DepInfo.add(new DepartmentAttribute("Dep6 ", "70 Emp", "15 EmpOn"));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define instance of Arraylist Depinfo = Department Information
        DepInfo = new ArrayList<DepartmentAttribute>();
        getDepInfo();

        //passing the Depinfo which contain the Data .
        CustomArrayAdapter myDepartment = new CustomArrayAdapter(DepInfo) ;

        //find the listview we want to show the data on and invoke setadapter to implement each Row
        ListView ls = (ListView) findViewById(R.id.departmentListView);
        ls.setAdapter(myDepartment);
    }

    //Custom ArrayAdapter Class
    class CustomArrayAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        ArrayList<DepartmentAttribute> DepInfo = new ArrayList<DepartmentAttribute>();

        CustomArrayAdapter(ArrayList<DepartmentAttribute> DepInfo) {

            this.DepInfo = DepInfo;
        }


        public int getCount() {
            return DepInfo.size();
        }

        public String getItem(int position) {
            return DepInfo.get(position).departmentName;
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            mInflater = getLayoutInflater();
            View view1 = mInflater.inflate(R.layout.custome_listview, null);

            TextView departmentTextView = (TextView) view1.findViewById(R.id.departmentTextView);
            TextView employeeCountTextView = (TextView) view1.findViewById(R.id.employeeCountTextView);
            TextView employeeOnTextView = (TextView) view1.findViewById(R.id.employeeOnTextView);

            departmentTextView.setText(DepInfo.get(i).departmentName);
            employeeCountTextView.setText(DepInfo.get(i).employeeTotal);
            employeeOnTextView.setText(DepInfo.get(i).employeeOn);


            return view1;

        }
    }



    }



