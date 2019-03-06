package br.com.desafio.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import br.com.desafio.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Enzo Teles on 06/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */


public class TypefaceTextView extends AppCompatTextView {
    public static Map<String, Typeface> typefaceCache = new HashMap();

    public TypefaceTextView(Context context) {
        super(context);
    }

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            setTypeface(attrs, this);
        }
    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            setTypeface(attrs, this);
        }

    }


    private void setTypeface(AttributeSet attrs, TextView textView) {
        Context context = textView.getContext();
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.CustomTypeFace);
        String typefaceName = values.getString(R.styleable.CustomTypeFace_typeface);
        values.recycle();
        if(typefaceCache.containsKey(typefaceName)) {
            setType(textView, (Typeface)typefaceCache.get(typefaceName));
        } else {
            Typeface typeface;
            try {
                typeface = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + typefaceName);
            } catch (Exception var7) {
                Log.e("TypeFace", String.format("fonte não encontrada", new Object[]{typefaceName}));
                return;
            }

            typefaceCache.put(typefaceName, typeface);
            setType(textView, typeface);

        }


    }

    private void setType(TextView textView, Typeface typeface){
        if( this.getTypeface() == null){
            textView.setTypeface(typeface);
        }else{
            textView.setTypeface(typeface, this.getTypeface().getStyle());
        }

    }


}
