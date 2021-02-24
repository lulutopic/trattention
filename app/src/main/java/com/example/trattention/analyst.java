package com.example.trattention;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class analyst<StepEntity> extends AppCompatActivity  {

    private ListView listview;
    private List<StepEntity> stepEntityList = new ArrayList<>();
    private StepDataDao stepDataDao;
    private LineChartView lineChart;
    private List<StepEntity> list;

    String[] date ;
    float [] score;
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stepDataDao = new StepDataDao(this);
        initView();
        list = stepDataDao.getAllDatas(  );
        date=new String[list.size()];
        score=new float[list.size()];

        for (int i=0;i<list.size();i++){

            date[i]=list.get(i).getCurDate();
            score[i]=Float.parseFloat(list.get(i).getSteps());
        }

        getAxisXLables();
        getAxisPoints();
        initLineChart();
    }

    private void initLineChart(){
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);    //折線圖上每個數據點的形狀，這裏是圓形
        line.setCubic(false);
        line.setFilled(false);
        line.setHasLabels(true);
        line.setHasLines(true);
        line.setHasPoints(true);
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //座標軸
        Axis axisX = new Axis();
        axisX.setHasTiltedLabels(true);
        axisX.setTextColor(Color.parseColor("#D6D6D9"));//設置字體顏色

        axisX.setTextSize(8);//設置字體大小
        axisX.setMaxLabelChars(8);//最多幾個X軸座標
        axisX.setValues(mAxisXValues);
        data.setAxisXBottom(axisX);
        axisX.setHasLines(true);


        Axis axisY = new Axis();
        axisY.setName("");
        axisY.setTextSize(8);
        data.setAxisYLeft(axisY);
        //設置行爲屬性，縮放、滑動、平移
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);
        lineChart.setMaxZoom((float) 3);
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);
        //設置X軸數據的顯示個數（x軸0-7個數據）
        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
        v.right= 7;
        lineChart.setCurrentViewport(v);
    }

    private void initView() {

        listview=(ListView) findViewById(R.id.listview);
        lineChart = (LineChartView)findViewById(R.id.line_chart);
    }


    private void getAxisXLables(){
        for (int i = 0; i < date.length; i++) {
            mAxisXValues.add(new AxisValue(i).setLabel(date[i]));
        }
    }

    private void getAxisPoints(){
        for (int i = 0; i < score.length; i++) {
            mPointValues.add(new PointValue(i, score[i]));
        }
    }

}