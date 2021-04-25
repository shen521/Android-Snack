package com.example.android_snack;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Images extends View {
    private int BitmapX,BitmapY;
    private int FoodX,FoodY;



    private int[] snackX=new int[Macro.MAX_LENGHT];
    private int[] snackY=new int[Macro.MAX_LENGHT];
    private int lenght;
    private int direction;
    private boolean islive;

    public boolean isIslive() {
        return islive;
    }

    public void setIslive(boolean islive) {
        this.islive = islive;
    }

    public int getFoodX() {
        return FoodX;
    }

    public void setFoodX(int foodX) {
        FoodX = foodX;
    }

    public int getFoodY() {
        return FoodY;
    }

    public void setFoodY(int foodY) {
        FoodY = foodY;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getBitmapX() {
        return BitmapX;
    }

    public void setBitmapX(int bitmapX) {
        BitmapX = bitmapX;
    }

    public int getBitmapY() {
        return BitmapY;
    }

    public void setBitmapY(int bitmapY) {
        BitmapY = bitmapY;
    }

    public Images(Context context) {
        super(context);
    }

    /**
     * Init.小蛇初始化
     */
    public void Init(){
        BitmapX=Macro.INIT_SNACKX;
        BitmapY=Macro.INIT_SNACKY;
        FoodX=Macro.INIT_FOODX;
        FoodY=Macro.INIT_FOODY;

        snackX[0]=BitmapX;
        snackY[0]=BitmapY;
        lenght=Macro.INIT_LENGHT;
        direction=Macro.Right;
        islive=true;

        for(int i=1;i<lenght;i++){
            snackX[i]=snackX[i-1]-Macro.UNIT;
            snackY[i]=snackY[i-1];
        }
    }


    private   Bitmap rbitmaphead,lbitmaphead,ubitmaphead,dbitmaphead,bitmapbody;
    private BitmapFactory.Options headoptions,bodyoptions;

    /**
     * Size.//引用小蛇图片，小蛇头部上下左右方向，并设置图片大小
     */
    public void Size(){
        headoptions=new BitmapFactory.Options();
        headoptions.inSampleSize= Macro.IMAGE_HEAD_SIZE;
        headoptions.inJustDecodeBounds=false;
        /**inJustDecodeBounds
         *如果将这个值置为true，那么在解码的时候将不会返回bitmap，只会返回这个bitmap的尺寸。
         * 这个属性的目的是，如果你只想知道一个bitmap的尺寸，但又不想将其加载到内存时。这是一个非常有用的属性。
         *
         * inSampleSize
         * 这个值是一个int，当它小于1的时候，将会被当做1处理，
         * 如果大于1，那么就会按照比例（1 / inSampleSize）缩小bitmap的宽和高、降低分辨率，大于1时这个值将会被处置为2的倍数。
         * 例如，width=100，height=100，inSampleSize=2，那么就会将bitmap处理为，width=50，height=50，宽高降为1 / 2，像素数降为1 / 4。
         */

        bodyoptions=new BitmapFactory.Options();//此类用于解码Bitmap时的各种参数控制
        bodyoptions.inSampleSize=Macro.IMAGE_BODY_SIZE;
        bodyoptions.inJustDecodeBounds=false;

        rbitmaphead= BitmapFactory.decodeResource(this.getResources(),R.drawable.rhead, headoptions);
        ubitmaphead= BitmapFactory.decodeResource(this.getResources(),R.drawable.head, headoptions);
        lbitmaphead= BitmapFactory.decodeResource(this.getResources(),R.drawable.lhead, headoptions);
        dbitmaphead= BitmapFactory.decodeResource(this.getResources(),R.drawable.dhead, headoptions);
        bitmapbody=BitmapFactory.decodeResource(this.getResources(),R.drawable.body,bodyoptions);
    }

    /**
     * onDraw//画蛇，将蛇画在屏幕上 canvas用于绘制背景的画布
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();//生成一个画笔对象

        //画食物

        /**
         * Draw the specified bitmap, with its top/left corner at (x,y), using the specified paint,
         * transformed by the current matrix.
         * <p>
         * Note: if the paint contains a maskfilter that generates a mask which extends beyond the
         * bitmap's original width/height (e.g. BlurMaskFilter), then the bitmap will be drawn as if it
         * were in a Shader with CLAMP mode. Thus the color outside of the original width/height will be
         * the edge color replicated.
         * <p>
         * If the bitmap and canvas have different densities（密度）, this function will take care of
         * automatically scaling the bitmap to draw at the same density as the canvas.
         *
         * @param bitmap The bitmap to be drawn 一个位图被画出来了
         * @param left The position of the left side of the bitmap being drawn
         * @param top The position of the top side of the bitmap being drawn
         * @param paint The paint used to draw the bitmap (may be null)
         */
        canvas.drawBitmap(bitmapbody, FoodX, FoodY, paint);

        //画出小蛇头部位置
        snackX[0]=BitmapX;
        snackY[0]=BitmapY;
        switch (direction){
            case Macro.Right:
                canvas.drawBitmap(rbitmaphead,snackX[0],snackY[0],paint);//蛇头往右，读取x、y坐标，填充画笔
                break;
            case Macro.Up:
                canvas.drawBitmap(ubitmaphead,snackX[0],snackY[0],paint);
                break;
            case Macro.Left:
                canvas.drawBitmap(lbitmaphead,snackX[0],snackY[0],paint);
                break;
            case Macro.Dwon:
                canvas.drawBitmap(dbitmaphead,snackX[0],snackY[0],paint);
                break;
        }
        //画出小蛇身体的位置
        for(int i=1;i<lenght;i++) {
            canvas.drawBitmap(bitmapbody, snackX[i], snackY[i], paint);
        }
        //小蛇咬住身体了
        for(int i=1;i<lenght;i++){
            if(snackX[0]==snackX[i]&&snackY[0]==snackY[i]){
                islive=false;
            }
        }
        //身体从最后一节向前一节位置移动
        for(int i=lenght;i>0;i--){
            snackX[i]=snackX[i-1];
            snackY[i]=snackY[i-1];
        }
        /**
         * Returns true if this bitmap has been recycled. If so, then it is an error
         * to try to access its pixels, and the bitmap will not draw.
         **如果该位图已被回收，则返回true。如果是，则是一个错误
         *             *试图访问其像素，位图将不会绘制。
         *             *如果位图已经被回收，返回true
         * @return true if the bitmap has been recycled
         */

        //图片回收
        if(rbitmaphead.isRecycled()){
            rbitmaphead.recycle();
        }
        if(bitmapbody.isRecycled()){
            bitmapbody.recycle();
        }
        if(ubitmaphead.isRecycled()){
            rbitmaphead.recycle();
        }
        if(lbitmaphead.isRecycled()){
            rbitmaphead.recycle();
        }
        if(dbitmaphead.isRecycled()){
            rbitmaphead.recycle();
        }
    }
}
