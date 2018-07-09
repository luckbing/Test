package com.example.admin.mytestgit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.example.admin.mytestgit.brvahdemo.activity.ExpandableItemActivity;
import com.example.admin.mytestgit.pagerslidingtabstrip.activity.PagerSlidingTabStripDemoActivity;
import com.example.admin.mytestgit.utils.StrZipUtil;
import com.example.admin.mytestgit.videoplayerdemo.activity.VideoPlayerActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_zip)
    AppCompatButton mBtnZip;
    @BindView(R.id.btn_unzip)
    AppCompatButton mBtnUnzip;
    private String mTempStr;
    private String mZipStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        mBtnZip = findViewById(R.id.btn_zip);
        mBtnUnzip = findViewById(R.id.btn_unzip);
//        mBtnZip.setOnClickListener(this);
//        mBtnUnzip.setOnClickListener(this);
    }

    @OnClick(R.id.btn_zip)
    void zipStr(View view) {
        Toast.makeText(this, "压缩", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_unzip)
    void unZipStr() {
        Toast.makeText(this, "解压缩", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_goto_expandable_item_activity)
    void gotoActivityExpandableItem() {
        startActivity(ExpandableItemActivity.getInstance(this));
    }

    @OnClick(R.id.btn_goto_pager_demo_activity)
    void gotoActivityPagerDemo() {
        startActivity(PagerSlidingTabStripDemoActivity.getInstance(this));
    }

    @OnClick(R.id.btn_goto_videoplayaer_demo_activity)
    void gotoActivityVideoPlayerDemo() {
        startActivity(VideoPlayerActivity.getInstance(this));
    }


    private void init() throws IOException {
//        mTempStr = "l;jsafljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                "看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 " +
//                "看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀" +
//                " 看看看看看看看看 ";

        mTempStr = "6月的第三个星期日是父亲节，我国的父亲节起源，要追溯到国民时代。*三十四年的八月八日(1945年8月8日)，上海闻人所发起了庆祝父亲节的活动，市民立即响应，热烈举行庆祝活动。抗日战争胜利后，上海市各界名流仕绅，联名请上海市政府转呈中央政府，定“爸爸”谐音的八月八日为全国性的父亲节。\n" +
                "\n" +
                "虽然今日一般人对于父亲节的庆祝活动，不像对母亲节一般的重视与热闹，但是我们对于父母的关爱却是一致的，当母亲含辛茹苦地照顾我们时，父亲也在努力地扮演着他的温柔角色;或许当我们努力思考着该为父亲买什么样的礼物过父亲节之时，不妨反省一下，我们是否爱我们的父亲，像他曾为我们无私地付出一生呢?\n" +
                "\n" +
                "记得上小学的时候，爸爸总是早出晚归，很少见到他，但是我还是能感觉到他对我的爱。。记得有一次，我想要买一本书，我和同学找了好久都没找到。后来我跟爸爸说了这件事，爸爸便抽出星期天的时间，带我去书店找书，几经周折，2小时后，我终于找到我要的那本书了，心里别提多高兴了，同时我也感觉到了爸爸对我默默的爱。\n" +
                "\n" +
                "爸爸的手机套很旧了，我准备给爸爸新买一个。我存了好久的钱，到了父亲节这一天，我存了10元钱，我拿了爸爸的旧手机套到手机店买相同大小手机套。逛了一会儿，我看中了一个带花纹的，想买下来，但是一看价格，要15元。我向卖手机套的销售员讨价还价：“这个手机套怎么这么贵啊!便宜点吧!”“那就算你13元好了。”销售员说道。我又说：“能不能再便宜点?我只有10元钱?”销售员说：“不行，你一个小孩买什么手机套，难道你已经有手机了吗?”我说：“才不是呢!今天是父亲节，我想帮爸爸买一个新的手机套。”销售员恍然大悟：“是我错怪你了，那就算你10元好了。”我高高兴兴的买走了手机套。回到家，我看到爸爸在找什么东西，我问爸爸：“你找什么呀?”爸爸说：“你有没有看到我的手机套，我突然找不到了。”我说：“没有啊!你既然在找手机套，拿手机就借我玩吧!”爸爸同意了。我偷偷的把手机套装好，对爸爸说：“爸爸，你的手机套在这呢，我给你装好了。”爸爸一看觉得有点奇怪，过了一会儿，爸爸恍然大悟，刮了刮我的鼻子，微笑着说：“原来今天是父亲节，真是个好儿子。”我听了别提多高兴了。\n" +
                "\n" +
                "爸爸你为我付出了这么多。爸爸，我爱您，这是我一直以来就一直想对您说的心里话，每一次父亲节都想告诉您，可是，我从来都没有说出口，如今，又一次的父亲节来临，我想让您知道——我爱您，爸爸\n";


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zip:
                System.out.println("原字符串=" + mTempStr);
                System.out.println("原长=" + mTempStr.length());
                try {
                    mZipStr = StrZipUtil.compress(mTempStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("压缩后的字符串=" + mZipStr);
                System.out.println("压缩后的长=" + mZipStr.length());
                break;
            case R.id.btn_unzip:
                try {
                    System.out.println("解压后的字符串=" + StrZipUtil.uncompress(mZipStr));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_goto_expandable_item_activity:
//                startActivity(ExpandableItemActivity.getInstance(getApplicationContext()));
                break;
            default:
                break;
        }
    }
}
