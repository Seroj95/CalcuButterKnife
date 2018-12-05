package ru.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.etBillAmount)
    EditText etBillAmount;
    @BindView(R.id.tvTipPercenr)
    TextView tvTipPercenr;
    @BindView(R.id.tvTipAmount)
    TextView tvTipAmount;
    @BindView(R.id.tvBillTopalAmount)
    TextView tvBillTopalAmount;

//haytararum enq 3 popoxakan wronq peteq = linen 0-i

    float percetage = 0;
    float tipTotal = 0;

    float finalBillAmount = 0;
float totalBillAmont=0;

    float REGULAR_TIP_PERCENATGE = 10;
    float DEFAULT_TIP_PERCENTAGE = 15;

    float EXCELLENT_TIP_PERCENTAGE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTipValues();
    }
//  avelacnenq metod setTipValues();, arjeqnery sahmanelu hamarTOXI yndhanur arjeqy
    private void setTipValues() {
// ID.SETTEXT,kanchenq stringic R.string,heto popoxakany vory verevum haytararecinq
        tvTipPercenr.setText(getString(R.string.mainmsgtippercent, percetage));
        tvTipAmount.setText(getString(R.string.mainmsgtiptotal, tipTotal));
        //verjnakan gumary
        tvBillTopalAmount.setText(getString(R.string.mainmsgbilltotalresult, finalBillAmount));
    }


    @OnClick({R.id.ibRegularservice, R.id.ibGoodService, R.id.ibExcellentService})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibRegularservice:
                percetage = REGULAR_TIP_PERCENATGE;
                break;
            case R.id.ibGoodService:
                percetage = DEFAULT_TIP_PERCENTAGE;
                break;
            case R.id.ibExcellentService:
                percetage = EXCELLENT_TIP_PERCENTAGE;
                break;
        }

        calculatFinalBill();
        setTipValues();
    }

    @OnTextChanged(R.id.etBillAmount)
    public void onTextChanged() {
        calculatFinalBill();
        setTipValues();
    }

    private void calculatFinalBill() {
        if(percetage==0)
            percetage=DEFAULT_TIP_PERCENTAGE;
        if(!etBillAmount.getText().toString().equals("")&&!etBillAmount.getText().toString().equals("."))
    totalBillAmont=Float.valueOf(etBillAmount.getText().toString());
        else
            totalBillAmont=0;
        tipTotal=(totalBillAmont*percetage)/100;
        finalBillAmount =totalBillAmont+tipTotal;

    }
}
