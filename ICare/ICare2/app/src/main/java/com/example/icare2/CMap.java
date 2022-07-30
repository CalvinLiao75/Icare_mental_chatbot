package com.example.icare2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.URI;
import java.util.ArrayList;

public class CMap extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private GoogleMap mMap;
    private FusedLocationProviderClient mLocationClient;
    private boolean mbIsZoomFirst = true;
    LatLng mylocation;
    Spinner spnClinics;
    ArrayAdapter AP;
    Uri uri;
    private static String[] mLocations = {
            "",
            "25.127449924574044, 121.73822053749979",//基隆
            "25.03237878288764, 121.56484685582966",//台北
            "25.01713520849769, 121.46253667767465",//新北
            "24.993930551169225, 121.30073068555873",//桃園
            "24.813663781419958, 120.96731176565179",//新竹
            "24.560112289155786, 120.82129044228043",//苗栗
            "24.147736724981797, 120.67347902317545",//台中
            "24.052752694100384, 120.51544795578057",//彰化
            "23.960839109547063, 120.97192517535035",//南投
            "23.709456853869177, 120.43129568985836",//雲林
            "23.480107527189045, 120.44904029917969",//嘉義市
            "23.556542501064193, 120.42697074759288",//嘉義縣一間
            "23.00004611118921, 120.22682828809508",//台南
            "22.627358403819766, 120.30137458152824",//高雄
            "22.55194351008984, 120.54850008620794",//屏東
            "24.702498620813202, 121.73742584648353",//宜蘭
            "23.987040666031938, 121.60127815433817",//花蓮
            "22.761278946483404, 121.14372904610222"//台東
    };

    public CMap() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c_map, container, false);
        Spinner spnLocation = v.findViewById(R.id.Location);
        spnLocation.setOnItemSelectedListener(spnLocationOnItemSelected);
        spnClinics = v.findViewById(R.id.clinics);
        spnClinics.setOnItemSelectedListener(spnClinicsOnItemSelected);
        Button navi = v.findViewById(R.id.naviBt);
        navi.setOnClickListener(naviClicked);


        SupportMapFragment supportMapFragment = new SupportMapFragment();
        supportMapFragment.getMapAsync(this);
        getChildFragmentManager().beginTransaction()
                .add(R.id.fragment, supportMapFragment)
                .commit();

        mLocationClient = new FusedLocationProviderClient(getActivity());

        return v;
    }
    private View.OnClickListener naviClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(uri.toString().length()>0) {
                Intent intent = new Intent(Intent.ACTION_QUICK_VIEW, uri);
                startActivity(intent);
            }
        }
    };

    @SuppressLint("MissingPermission")
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        //chiayi
        LatLng chiayi = new LatLng(23.478537, 120.449950);
        LatLng chiayi_1 = new LatLng(23.468523494225046, 120.44338445488623);
        LatLng chiayi_2 = new LatLng(23.475928041272464, 120.44478339721483);
        LatLng chiayi_3 = new LatLng(23.471882865410855, 120.4448408125579);
        LatLng chiayi_4 = new LatLng(23.480855533550326, 120.45401659721485);
        LatLng chiayi_5 = new LatLng(23.481176154273374, 120.46094339721478);
        LatLng chiayi_6 = new LatLng(23.47951555458924, 120.44445175673697);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(chiayi_1).title("吳南逸診所"));
        mMap.addMarker(new MarkerOptions().position(chiayi_2).title("真善渼診所"));
        mMap.addMarker(new MarkerOptions().position(chiayi_3).title("太和診所"));
        mMap.addMarker(new MarkerOptions().position(chiayi_4).title("周裕軒身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(chiayi_5).title("蕭正誠診所"));
        mMap.addMarker(new MarkerOptions().position(chiayi_6).title("知心連冀身心醫學科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.5565266950828, 120.42696880379124)).title("徐鴻傑身心診所"));
        //基隆
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.1280683512066, 121.75107665491528)).title("基隆心身心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.130473210410003, 121.74714999724375)).title("詠欣精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.095724883870602, 121.71282219724291)).title("紀醫師診所"));
        //台北
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.0256404271, 121.53611999724183)).title("大安身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.041255024618174, 121.5531601395705)).title("向陽身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.052596780822668, 121.52136183895861)).title("黃雅芬兒童心智診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.053790658241432, 121.53335407552217)).title("鈺璽診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.082172626403406, 121.54873094094967)).title("進安身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.104297506626494, 121.52118489677174)).title("天母康健身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.082588220753138, 121.51059479257269)).title("社子安心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.128859198520257, 121.50129485444347)).title("奇岩身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.113732832387637, 121.51102382560752)).title("石牌鄭身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.132375095454236, 121.49917975024175)).title("北辰身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.047579334726322, 121.55344687296659)).title("邱楠超診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.056904608873776, 121.56376034228214)).title("李政洋身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.051244195874588, 121.56826665762416)).title("双悅診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.982952646853214, 121.56609576714142)).title("泓仁診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.001653817463435, 121.55491333975269)).title("木柵身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.001798031042778, 121.53888993748554)).title("和沛身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.024442879564486, 121.50994373871023)).title("福全身心科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.026266282817456, 121.5540784448447)).title("醫者診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.07966672256749, 121.58998921109976)).title("夏一新精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.056651734054753, 121.51742548623295)).title("夏凱納生活診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.024186209836138, 121.52432319760574)).title("大心診所(古亭) "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.042819119318022, 121.53046129760611)).title("捷思身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.05471445553096, 121.60489596202414)).title("開馨診所"));
        //新北
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.01708738390761, 121.47688549724158)).title("順心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.01778545056935, 121.4572567972416)).title("心世界身心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.068735493139663, 121.6126103687709)).title("林威廷身心精神科診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.068350480866087, 121.66104930814238)).title("合康診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.959170872206286, 121.51434148088003)).title("怡濟慈園醫療社團法人宏濟神經精神科醫院"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.97932815116676, 121.54246425760395)).title("新店北新身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.992386270066923, 121.51159925208523)).title("樂活精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.00395939801739, 121.51564042816284)).title("永和開心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.003226980596743, 121.51246827786956)).title("寧靜海診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.00252215526503, 121.49896125017888)).title("維品身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.986903543206974, 121.45439173538543)).title("悠活精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.035639581454483, 121.52774004061986)).title("永康身心診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.95589580525464, 121.35572279532907)).title("養心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.067525044092896, 121.49614403445136)).title("美麗心成人兒童精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.057074315689007, 121.49660265517747)).title("孔繁錦診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.037921502665466, 121.4471907269759)).title("育心身心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.032920137776937, 121.43455504227533)).title("晴美身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.08530475661485, 121.46955477297735)).title("壬康精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.05474342722136, 121.54031133903749)).title("喜悅診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.993871112498447, 121.42332001157715)).title("樹新耳鼻喉科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.172395120661765, 121.4457909576585)).title("心悅身心診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.932712260198315, 121.37380815759086)).title("王湘琦身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.071547638264402, 121.36859645762996)).title("欣泉身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.075771707657527, 121.36991648831834)).title("龍霖身心診所"));
        //桃園
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.98706808400044, 121.31777392590385)).title("吳俊毅身心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.02021187385757, 121.2952015259046)).title("一德身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.966579897854974, 121.22554289478742)).title("順心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.97413408917495, 121.25617520452164)).title("尚語身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.960978866055346, 121.29984257576135)).title("雷亞診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.04897522623226, 121.29096854431558)).title("晨新聯合診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.87836099537373, 121.23470905012948)).title("國軍桃園總醫院精神科大樓"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.945529675602312, 121.20595386429925)).title("黃正龍診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.910409728575885, 121.15686342082971)).title("新楊梅診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.018744889966822, 121.40992401417516)).title("蘇宗偉身心診所  "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.058439950649095, 121.36444414557687)).title("清心身心診所 "));

        //新竹
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.82493803382664, 121.02422303755091)).title("安立身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.722623784125204, 121.09773293939422)).title("陽光精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.722703486906905, 121.09330896530987)).title("瑞安診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.7876834840943, 121.0111578970653)).title("馬大元診所"));
        //苗栗
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.554108084205435, 120.81880599706115)).title("益康診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.56330293163565, 120.8238137817212)).title("吳四維診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.439803884260115, 120.65611579705904)).title("天慈身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.688148680467684, 120.91051373275553)).title("承美身心科診所"));
        //台中
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.14265020363665, 120.6937418393838)).title("明功堂精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.145711204104007, 120.66004793938386)).title("中美偕診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.13647533703005, 120.66067068467405)).title("陽晴心理治療所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.123505915796144, 120.66535344953685)).title("欣悅診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.125373783763763, 120.66843514202446)).title("德仁診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.15515213698475, 120.68162603988982)).title("黃淑琦心身診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.171934895511654, 120.67161425948595)).title("詹益忠身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.140550888473534, 120.6774604595154)).title("詹東霖心身診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.170574970754895, 120.64446571109472)).title("昕晴診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.1528931098923, 120.64959021308786)).title("康誠心身醫學診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.141532659277146, 120.63823784701059)).title("趙玉良身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.168195576631256, 120.69600030568408)).title("尚義診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.17409333672675, 120.67219452824813)).title("文心樂丞診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.1154167254709, 120.68789497571223)).title("鄭曜忠身心診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.250444680662778, 120.71083244301056)).title("世淋診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.21378603246353, 120.7054190001381)).title("好晴天身心診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.1587360017662, 120.72038290340127)).title("蕭芸嶙身心醫學診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.24624898393789, 120.56236039916544)).title("新活力診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.30464009094153, 120.71283866881645)).title("后里診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.04649215063007, 120.69268904786243)).title("簡亦淇診所"));





        //彰化
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.088948172273895, 120.5343950118328)).title("修慧診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.072573982965217, 120.54285581055963)).title("頤晴診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.965644743362752, 120.57695080329042)).title("存寬診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.901905942072815, 120.53714787442446)).title("李光耀診所"));

        mMap.addMarker(new MarkerOptions().position(new LatLng(23.873797919756253, 120.52174798189921)).title("陳建達診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.114378829620524, 120.49311398074929)).title("和美身心醫學診所"));



        //南投
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.9709690647335, 120.97692402436786)).title("惠承診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.90956465496752, 120.6897114052034)).title("惠良診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.756150197960437, 120.69142600630475)).title("惠元診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.98090280338201, 120.68592393508482)).title("協安診所"));
        //雲林
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.704009349305245, 120.53384202096682)).title("何正岳診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.71220760341417, 120.43661911186437)).title("趙夢麒診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.701090770625488, 120.5290969970462)).title("雲萱診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.709635031144014, 120.5473870075544)).title("晴明身心診所"));
        //台南
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.001798470397656, 120.18717873683484)).title("晟欣診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.974560246080813, 120.22895259639034)).title("王盈彬精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.992928823906947, 120.23030138476503)).title("心樂活診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.97319379334453, 120.19087362248632)).title("康舟診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.001952338417905, 120.19639251875465)).title("心悠活診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.002933079767256, 120.22446886384994)).title("上善心理治療所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.068248768224088, 120.21682533198702)).title("吳吉得診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.039492473818868, 120.18799778081447)).title("安大身心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.999652827869024, 120.1760556676353)).title("安平心寬診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.01188665663732, 120.22679344866245)).title("林俞仲身心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.998667036193925, 120.23925997548821)).title("心永康身心精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(25.06432153040177, 121.52551533436937)).title("晴光診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.079737859852912, 120.29410127466994)).title("同行身心診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.181952592056682, 120.25167151708834)).title("安芯診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.966375522134182, 120.28795329929518)).title("心田診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.30588266140468, 120.31973806547724)).title("林晏弘診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.16319561039653, 120.17785468092178)).title("明如身心診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.16497830799246, 120.17771111950657)).title("瓏芯診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.34723934686685, 120.41387219921025)).title("白河林眼科診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.03576409950925, 120.302940901123)).title("陳相國聯合診所"));



        //高雄
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.630661290559644, 120.31562378124882)).title("青欣診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.625202262501663, 120.30677969019459)).title("榮欣身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.62724086132817, 120.30035900228432)).title("柯偉恭診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.617421700135857, 120.30692281444068)).title("家慈診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.62019104920722, 120.31687821937253)).title("雲上太陽心寧診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.621835553835236, 120.32902178970238)).title("佳璋診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.655623411969852, 120.29192349929889)).title("樂群診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(222.61321989106164, 120.31498730663381)).title("大福診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.611770797661038, 120.32493163506946)).title("佳欣診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.648370014983982, 120.32002018151957)).title("心悅診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.64827154355305, 120.31938112460465)).title("建工心喜診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.653528778533552, 120.31916858919352)).title("大順景福診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.643624989343714, 120.30984958093207)).title("健泰診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.71100518243223, 120.29257017530043)).title("郭玉柱診所 "));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.721906630578594, 120.29142110002185)).title("心欣診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.566163292090007, 120.35198379431306)).title("李宣炘診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.567158470160937, 120.35863086717968)).title("康泰診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.67836549788903, 120.31366942299168)).title("李全忠診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.679564480341725, 120.30992071895633)).title("尋路身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.79371801919975, 120.29595073971123)).title("維心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.862713991973397, 120.26159464965697)).title("國良診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.62911632341704, 120.35882874125868)).title("季宏診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.63612134657444, 120.35981622266502)).title("信元聯合診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.885260543243575, 120.48296206370738)).title("欣明精神科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.700875377251656, 120.35378259675169)).title("仁華診所"));

        //屏東
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.551153630174458, 120.53838324140693)).title("泰祥診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.67168876443601, 120.48653403961745)).title("寬心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.678980439591754, 120.50754556529314)).title("瑞興診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.702551049094264, 120.57604413725942)).title("晨安診所"));//兩個晨安
        //宜蘭
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.680989669201256, 121.77685717318175)).title("平和身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.755192334431875, 121.75650044696454)).title("光中身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(24.75505688775551, 121.74803269706476)).title("雅信診所"));
        //花蓮
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.985049522111865, 121.5945283264988)).title("福田耳鼻喉科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.988759822625912, 121.59497932340597)).title("同心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.988903338355712, 121.60051021331063)).title("中山身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.992120726590944, 121.57668156023522)).title("悅思身心診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(23.974627014856853, 121.59506170976844)).title("悅增身心診所"));
        //台東
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.782855896877347, 121.12782646583231)).title("楊國明身心科診所"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.751853260165756, 121.14889485507408)).title("陳柄辰身心科診所"));
        //mMap.addMarker(new MarkerOptions().position(new LatLng()).title(""));
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mLocationClient.getLastLocation().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Location location = task.getResult();
                gotoLocation(location.getLatitude(), location.getLongitude());
            }
        });

        mMap.animateCamera(CameraUpdateFactory.newLatLng(
                new LatLng(25.127449, 121.738220)));

        /* add route "no" code
        PolylineOptions aaa = new PolylineOptions().addAll().color().width().jointType();
        mMap.addPolyline(aaa);
        */
    }

    private void gotoLocation(double latitude, double longitude) {
        mylocation = new LatLng(latitude,longitude);
        mMap.addMarker(new MarkerOptions().position(mylocation).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocation,13));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }


    private AdapterView.OnItemSelectedListener spnLocationOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(i!=0) {

                ((TextView) adapterView.getChildAt(0)).setTextSize(20);
                String[] sLocation = mLocations[i].split(",");
                double dLat = Double.parseDouble(sLocation[0]);
                double dLon = Double.parseDouble(sLocation[1]);

                if (mbIsZoomFirst) {
                    mbIsZoomFirst = false;
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                            new LatLng(dLat, dLon), 13));
                    switch (i){
                        case 1:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c1,R.layout.support_simple_spinner_dropdown_item);
                        case 2:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c2,R.layout.support_simple_spinner_dropdown_item);
                        case 3:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c3,R.layout.support_simple_spinner_dropdown_item);
                        case 4:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c4,R.layout.support_simple_spinner_dropdown_item);
                        case 5:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c5,R.layout.support_simple_spinner_dropdown_item);
                        case 6:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c6,R.layout.support_simple_spinner_dropdown_item);
                        case 7:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c7,R.layout.support_simple_spinner_dropdown_item);
                        case 8:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c8,R.layout.support_simple_spinner_dropdown_item);
                        case 9:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c9,R.layout.support_simple_spinner_dropdown_item);
                        case 10:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c10,R.layout.support_simple_spinner_dropdown_item);
                        case 11:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c11,R.layout.support_simple_spinner_dropdown_item);
                        case 12:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c12,R.layout.support_simple_spinner_dropdown_item);
                        case 13:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c13,R.layout.support_simple_spinner_dropdown_item);
                        case 14:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c14,R.layout.support_simple_spinner_dropdown_item);
                        case 15:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c15,R.layout.support_simple_spinner_dropdown_item);
                        case 16:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c16,R.layout.support_simple_spinner_dropdown_item);
                        case 17:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c17,R.layout.support_simple_spinner_dropdown_item);
                    }
                    spnClinics.setAdapter(AP);
                } else {
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(
                            new LatLng(dLat, dLon)));
                    switch (i){
                        case 1:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c1,R.layout.support_simple_spinner_dropdown_item);
                        case 2:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c2,R.layout.support_simple_spinner_dropdown_item);
                        case 3:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c3,R.layout.support_simple_spinner_dropdown_item);
                        case 4:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c4,R.layout.support_simple_spinner_dropdown_item);
                        case 5:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c5,R.layout.support_simple_spinner_dropdown_item);
                        case 6:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c6,R.layout.support_simple_spinner_dropdown_item);
                        case 7:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c7,R.layout.support_simple_spinner_dropdown_item);
                        case 8:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c8,R.layout.support_simple_spinner_dropdown_item);
                        case 9:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c9,R.layout.support_simple_spinner_dropdown_item);
                        case 10:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c10,R.layout.support_simple_spinner_dropdown_item);
                        case 11:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c11,R.layout.support_simple_spinner_dropdown_item);
                        case 12:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c12,R.layout.support_simple_spinner_dropdown_item);
                        case 13:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c13,R.layout.support_simple_spinner_dropdown_item);
                        case 14:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c14,R.layout.support_simple_spinner_dropdown_item);
                        case 15:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c15,R.layout.support_simple_spinner_dropdown_item);
                        case 16:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c16,R.layout.support_simple_spinner_dropdown_item);
                        case 17:
                            AP = ArrayAdapter.createFromResource(getContext(),R.array.c17,R.layout.support_simple_spinner_dropdown_item);
                    }
                    spnClinics.setAdapter(AP);
                }

                uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin="+mylocation.latitude+","+mylocation.longitude
                      +"&destination="+"23.5565266950828, 120.42696880379124");

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener spnClinicsOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}