package pmcg.imti.cursoimti;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 07/08/15.
 */
public class registerActivity extends AppCompatActivity {

    private final int CAMERA_REQUEST = 123;

    @Bind(R.id.user_image)
    ImageView userImage;

    @Bind(R.id.name)
    EditText name;

    @Bind(R.id.email)
    EditText email;

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.user_image)
    public void changeImage() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST && resultCode==RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
        }
        else {
            Toast.makeText(registerActivity.this, "Imagem não selecionada.", Toast.LENGTH_SHORT ).show();
        }
    }
}
