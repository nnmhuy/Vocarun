package com.example.vocarun;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionLabelDetector;

import java.util.List;

public class FirebaseMLKit {
    private void checkImageMapWord(Bitmap bitmap, final String word) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);

        //Get access to an instance of FirebaseImageDetector
         FirebaseVisionLabelDetector detector = FirebaseVision.getInstance().getVisionLabelDetector();

        //Use the detector to detect the labels inside the image
        detector.detectInImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionLabel>>() {
            @Override
            public void onSuccess(List<FirebaseVisionLabel> firebaseVisionLabels) {
                for (int i = 0; i < firebaseVisionLabels.size(); ++i) {
                    if (firebaseVisionLabels.get(i).getLabel().equals(word)) {
                        // Call correct function
                        break;
                    }
                }
                // Call wrong function
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}
