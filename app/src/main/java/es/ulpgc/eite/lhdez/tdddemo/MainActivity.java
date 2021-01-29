package es.ulpgc.eite.lhdez.tdddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private TextView message;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    message = findViewById(R.id.message);
    message.setVisibility(View.INVISIBLE);
  }

  public void tapButton(View view) {
    message.setVisibility(View.VISIBLE);
  }
}