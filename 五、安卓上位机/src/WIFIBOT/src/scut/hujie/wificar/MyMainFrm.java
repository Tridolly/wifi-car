package scut.hujie.wificar;

import my.wificar.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyMainFrm extends Activity {

	private EditText CameraIP;// ȫ��ַ
	private EditText ControlIP;// IP��
	private EditText Port;// �˿ں�
	private Button Button_go;// ȷ�ϰ�ť
	private String videoUrl;// ��ȡCameraIP������
	private String controlUrl;// ��ȡControlIP������
	private String port;// ��ȡPort������
	public static String CameraIp;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * ������ǵ�һ�����棬�ڽ����п���������������ͷ�Ļ�ȡ��Ƶ��������ַ edIP����Ƶ��ַ�ı��� Button_go ������ť
		 */

		setContentView(R.layout.mymainfrm);

		CameraIP = (EditText) findViewById(R.id.editIP);
		ControlIP = (EditText) findViewById(R.id.ip);
		Port = (EditText) findViewById(R.id.port);

		Button_go = (Button) findViewById(R.id.button_go);

		videoUrl = CameraIP.getText().toString();
		controlUrl = ControlIP.getText().toString();
		port = Port.getText().toString();

		Button_go.requestFocusFromTouch();

		Button_go.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				// ����һ��Intent����
				Intent intent = new Intent();
				// ��Intent���������һ����ֵ��
				intent.putExtra("CameraIp", videoUrl);
				intent.putExtra("ControlUrl", controlUrl);
				intent.putExtra("Port", port);

				intent.putExtra("Is_Scale", true);
				// ����Intent����Ҫ������Activity
				intent.setClass(MyMainFrm.this, MyVideo.class);
				// ͨ��Intent������������һ��Activity
				startActivity(intent);
				finish();
				System.exit(0);
			}
		});

	}

	/*
	 * ����Ϊ��һ�·��ؼ�����ʾ���ٰ�һ���˳�����
	 */
	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {

			if ((System.currentTimeMillis() - exitTime) > 2000) // System.currentTimeMillis()���ۺ�ʱ���ã��϶�����2000
			{
				Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
