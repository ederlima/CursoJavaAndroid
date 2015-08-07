package pmcg.imti.cursoimti;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.camera.CropImageIntentBuilder;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 07/08/15.
 */
public class registerActivity extends AppCompatActivity {

    private final int CAMERA_REQUEST = 123;
    private final int CROP_REQUEST = 321;

    @Bind(R.id.user_image)
    ImageView userImage;

    @Bind(R.id.name)
    EditText name;

    @Bind(R.id.email)
    EditText email;

    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.register_activity);
        ButterKnife.bind(this);
    }

    /**
     * Usando imagerop pra cortar a imagem da câmera
     */
    @OnClick(R.id.user_image)
    public void changeImage() {
        //criando imagem temporário a partir do original
        File image = new File(getExternalCacheDir(), "temp");
        imageUri = Uri.fromFile(image);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //pedindo para a câmera gravar o arquivo
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        //abrindo a câmera
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //criando o arquivo
        File croppedImage  = new File(getFilesDir(), "imgCropped.jpg");

        if(requestCode==CAMERA_REQUEST && resultCode==RESULT_OK) {

            Uri croppedImageUri = Uri.fromFile(croppedImage);
            //utilizando imagecrop
            CropImageIntentBuilder crop = new CropImageIntentBuilder(200, 200, croppedImageUri);
            crop.setOutlineCircleColor(0xffffff);
            crop.setSourceImage(imageUri);
            /*Bitmap photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);*/

            startActivityForResult(crop.getIntent(registerActivity.this), CROP_REQUEST);

        }
        else if(requestCode==CROP_REQUEST && resultCode == RESULT_OK) {
            //retorno do crop
            userImage.setImageBitmap(BitmapFactory.decodeFile(croppedImage.getAbsolutePath()));

        }
        else {
            Toast.makeText(registerActivity.this, "Imagem não selecionada.", Toast.LENGTH_SHORT ).show();
        }
    }
}
