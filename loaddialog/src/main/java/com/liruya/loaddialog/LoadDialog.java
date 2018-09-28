package com.liruya.loaddialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class LoadDialog extends Dialog
{
    private View mContentView;
    private DisplayMetrics mDisplayMetrics;
    private TextView dialog_tv_msg;

    public LoadDialog( @NonNull Context context )
    {
        super( context );
        inflate( context );
    }

    public LoadDialog( @NonNull Context context, int themeResId )
    {
        super( context, themeResId );
        inflate( context );
    }

    protected LoadDialog( @NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener )
    {
        super( context, cancelable, cancelListener );
        inflate( context );
    }

    private void inflate( @NonNull Context context )
    {
        mContentView = LayoutInflater.from( context ).inflate( R.layout.dialog_load, null, false );
        dialog_tv_msg = mContentView.findViewById( R.id.dialog_tv_msg );
        mDisplayMetrics = context.getResources().getDisplayMetrics();
        setContentView( mContentView );
    }

    public void setText( String msg )
    {
        if ( dialog_tv_msg == null )
        {
            return;
        }

        dialog_tv_msg.setVisibility( TextUtils.isEmpty( msg ) ? View.GONE : View.VISIBLE );
        dialog_tv_msg.setText( TextUtils.isEmpty( msg ) ? "" : msg );
    }

    @Override
    public void show()
    {
        super.show();
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.width = mDisplayMetrics.widthPixels/2;
//        params.height = mDisplayMetrics.heightPixels/5;
//        params.gravity = Gravity.CENTER;
//        getWindow().setAttributes( params );
//        getWindow().setContentView( mContentView );
    }

    public static class Builder
    {
        private Context mContext;
        private int mTheme;
        private boolean mCancelable;
        private boolean mCanceledOnTouchOutside;
        private String mMessage;

        public Builder( @NonNull Context context )
        {
            this(context, R.style.DialogStyle, true, false);
        }

        public Builder( @NonNull Context context, int theme )
        {
            this(context, theme, true, false);
        }

        public Builder( @NonNull Context context, int theme, boolean cancelable, boolean canceledOnTouchOutside )
        {
            mContext = context;
            mTheme = theme;
            mCancelable = cancelable;
            mCanceledOnTouchOutside = canceledOnTouchOutside;
        }

        public Builder setCancelable( boolean cancelable )
        {
            mCancelable = cancelable;
            return this;
        }

        public Builder setCanceledOnTouchOutside( boolean canceledOnTouchOutside )
        {
            mCanceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public Builder setMessage( String message )
        {
            mMessage = message;
            return this;
        }

        public LoadDialog create()
        {
            LoadDialog dialog = new LoadDialog( mContext, mTheme );
            dialog.setText( mMessage );
            dialog.setCancelable( mCancelable );
            dialog.setCanceledOnTouchOutside( mCanceledOnTouchOutside );
            return dialog;
        }

        public LoadDialog show()
        {
            final LoadDialog dialog = create();
            dialog.show();
            return dialog;
        }
    }
}
