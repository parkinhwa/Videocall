package com.example.broadcast

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
<<<<<<< HEAD
=======
import android.widget.TextView
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
<<<<<<< HEAD
import androidx.databinding.DataBindingUtil
import com.example.broadcast.databinding.BroadcastBinding
=======
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
import com.google.android.material.snackbar.Snackbar
import com.remotemonster.sdk.RemonCall
import com.remotemonster.sdk.RemonException
import com.remotemonster.sdk.data.CloseType
<<<<<<< HEAD
=======
import kotlinx.android.synthetic.main.broadcast.*
import org.webrtc.SurfaceViewRenderer
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d


// 가장 단순한 형태의 P2P 통화에 대한 샘플입니다.
class broadcastActivity : AppCompatActivity() {
    private val REMON_PERMISSION_REQUEST = 0x0101
<<<<<<< HEAD

=======
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
    // RemonCall 객체 정의 - P2P 1:1 통화
    // 1:1 통화는 RemonCall 을 사용합니다.
    private var remonCall: RemonCall? = null

    // 안드로이드 UI에 관련된 부분
<<<<<<< HEAD
    private lateinit var binding: BroadcastBinding
=======
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
    private var constraintSet: ConstraintSet? = null
    private var defaultConstraintSet: ConstraintSet? = null


    private lateinit var inputMethodManager:InputMethodManager

    private var latestError:RemonException? = null

<<<<<<< HEAD
=======

>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // bind activity layout
<<<<<<< HEAD
        binding = DataBindingUtil.setContentView( this, R.layout.broadcast)
=======
        setContentView(R.layout.broadcast)
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d

        // 퍼미션 체크를 위한 루틴입니다.
        checkPermission()

        // 레이아웃 조절을 위해 activity_main.xml의 constraint 정보를 저장해 둡니다.
        constraintSet = ConstraintSet()
        defaultConstraintSet = ConstraintSet()
<<<<<<< HEAD
        constraintSet?.clone( binding.constraintLayout )
        defaultConstraintSet?.clone( binding.constraintLayout )
=======

>>>>>>> a31e77a347a4a993e36794e55de66658b938306d

        updateView(false)

        // 버튼 이벤트 연결
        // 연결, 종료 버튼 클릭이벤트를 정의합니다.
        // 연결 버튼 클릭시 RemonCall 을 초기화하고, connect(채널명) 메쏘드를 호출합니다.
<<<<<<< HEAD
        binding.btnConnect.setOnClickListener {
            if (binding.etChannelName.text.isEmpty()) {
                Snackbar.make( binding.rootLayout, "채널명을 입력하세요.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            inputMethodManager.hideSoftInputFromWindow(binding.etChannelName.windowToken, 0)
            binding.etChannelName.clearFocus()
=======
        btnConnect.setOnClickListener {
            if (etChannelName.text.isEmpty()) {
                Snackbar.make( rootLayout, "채널명을 입력하세요.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            inputMethodManager.hideSoftInputFromWindow(etChannelName.windowToken, 0)
            etChannelName.clearFocus()
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d

            // RemonCall 초기화
            initRemonCall()

            // RemonCall 연결
<<<<<<< HEAD
            remonCall?.connect(binding.etChannelName.text.toString())
            binding.btnConnect.isEnabled = false
            binding.btnClose.isEnabled = true
        }

        // 종료 버튼 클릭시 RemonCall 의 close() 메쏘드를 호출합니다.
        binding.btnClose.setOnClickListener {
=======
            remonCall?.connect(etChannelName.text.toString())
            btnConnect.isEnabled = false
            btnClose.isEnabled = true
        }

        // 종료 버튼 클릭시 RemonCall 의 close() 메쏘드를 호출합니다.
        btnClose.setOnClickListener {
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
            remonCall?.close()
            remonCall = null

        }

<<<<<<< HEAD
        // 메시지 버튼
        binding.btnSend.setOnClickListener {
            val msg = binding.etMessage.text.toString()
            binding.etMessage.text.clear()
            inputMethodManager.hideSoftInputFromWindow(binding.etMessage.windowToken, 0) //??
            binding.etMessage.clearFocus()

            if( remonCall == null ) {
                return@setOnClickListener
            }

            if( msg.isNotEmpty()) {
                remonCall?.sendMessage(msg)
            }
=======
        btnCamera.setOnClickListener{
            val Intent = Intent(this, PhotoActivity::class.java)
            startActivity(Intent)
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
        }
    }


<<<<<<< HEAD
=======

>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
    // RemonCall 초기화
    // Builder 를 사용해 각 설정 정보를 정의
    private fun initRemonCall() {
        remonCall = RemonCall.builder()
            .context(this)
            .serviceId( "SERVICEID1")
            .key("1234567890")
            .videoCodec("VP8")
            .videoWidth(640)
            .videoHeight( 480 )
<<<<<<< HEAD
            .localView( binding.surfRendererLocal)
=======
            .localView(surfRendererLocal as SurfaceViewRenderer?)
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
            .build()

        // SDK 의 이벤트 콜백을 정의합니다.
        initRemonCallback()
    }


    // 각 콜백 정의
    private fun initRemonCallback() {

        // RemonCall, RemonCast 의 초기화가 완료된 후 호출되는 콜백입니다.
        remonCall?.onInit {

        }

        // 서버 접속 및 채널 생성이 완료된 이후 호출되는 콜백입니다.
        remonCall?.onConnect { id: String ->
<<<<<<< HEAD
            Snackbar.make( binding.rootLayout, "채널($id)에 연결되었습니다.", Snackbar.LENGTH_SHORT).show()
=======
            Snackbar.make( rootLayout, "채널($id)에 연결되었습니다.", Snackbar.LENGTH_SHORT).show()
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
            updateView(false)

        }


        // 다른 사용자와 Peer 연결이 완료된 이후 호출되는 콜백입니다.
        remonCall?.onComplete {
            updateView(true)
        }

        // 상대방이 연결을 끊거나, close() 호출후 종료가 완료되면 호출됩니다.
        // CloseType.MINE : 자신이 close() 를 통해 종료한 경우
        // CloseType.OTHER : 상대방이 close() 를 통해 종료한 경우
        // CloseType.OTHER_UNEXPECTED : 상대방이 끊어져서 연결이 종료된 경우
        // CloseType.UNKNOWN : 에러에 의한 연결 종료, 기타 연결 종료 이유 불명확
        remonCall?.onClose { closeType:CloseType ->
            updateView(false)
<<<<<<< HEAD
            binding.btnConnect.isEnabled = true
            binding.btnClose.isEnabled = false
=======
            btnConnect.isEnabled = true
            btnClose.isEnabled = false
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d

            // 에러에 의한 종료인지 체크
            if(closeType == CloseType.UNKNOWN && latestError != null) {
                Snackbar.make(
<<<<<<< HEAD
                    binding.rootLayout,
=======
                    rootLayout,
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
                    "오류로 연결이 종료되었습니다. 에러=" + latestError?.description,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }


        // 에러가 발생할 때 호출되는 콜백을 정의합니다.
        // 연결이 종료되는 경우 에러 전달 후 onClose가 호출 되므로,
        // 시나리오에 따른 ux 처리는 onClose에서 진행되어야 합니다.
        remonCall?.onError { e ->
            Log.e("SimpleRemon", "error="+e.description)
            latestError = e

        }


        // 연결된 peer 간에 메시지를 전달하는 경우 호출되는 콜백입니다.
        remonCall?.onMessage { msg ->
<<<<<<< HEAD
            Snackbar.make( binding.rootLayout, msg, Snackbar.LENGTH_SHORT).show()
=======
            Snackbar.make( rootLayout, msg, Snackbar.LENGTH_SHORT).show()
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
        }
    }


    override fun onDestroy() {
        remonCall?.close()
        super.onDestroy()
    }



    // 연결된 이후 간단하게 레이아웃을 변경하는 예제입니다.
    // SDK가 아닌 서비스와 관련한 부분으로 참고용도로 살펴보시기 바랍니다.
    private fun updateView( isConnected: Boolean) {
<<<<<<< HEAD


        //메시지창 연결될 시 보이기 아니면 안보임
        if( isConnected ) {
            binding.layoutMessage.visibility = View.VISIBLE
        } else {
            binding.layoutMessage.visibility = View.GONE
        }

        if(isConnected) {
            val Intent = Intent(this, PhotoActivity::class.java)
            startActivity(Intent)
        }
=======
        if(isConnected) {
            surfRendererLocal.visibility = View.VISIBLE
            surfaceView.visibility = View.INVISIBLE
        }
        if(!isConnected) {
            surfRendererLocal.visibility = View.INVISIBLE
            surfaceView.visibility = View.VISIBLE
        }

>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
 6   }




    // 권한을 체크합니다.
    // 사용자에게 필수로 권한을 확인받아야 하는  요소는 CAMERA,RECORD_AUDIO,WRITE_EXTERNAL_STORAGE 입니다.
    private fun checkPermission() {

        // 안드로이드 6.0 미만의 경우 별도 체크하지 않습니다.
        if( Build.VERSION.SDK_INT < 23) {
            return
        }

        val mandatoryPermissions = arrayListOf(
            "android.permission.CAMERA",
            "android.permission.RECORD_AUDIO",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.CHANGE_NETWORK_STATE",
            "android.permission.MODIFY_AUDIO_SETTINGS",
            "android.permission.INTERNET",
            "android.permission.ACCESS_NETWORK_STATE",
            "android.permission.BLUETOOTH"
        )
        //허가했는지 list에 저장하는 듯?
        val grantList = mutableListOf<String>()
        for( permission in mandatoryPermissions ) {
            val permissionResult = ContextCompat.checkSelfPermission(this, permission)
            if (permissionResult != PackageManager.PERMISSION_GRANTED) {
                grantList.add(permission)
            }
        }
        //list 비어있을 시
        if(grantList.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, grantList.toTypedArray() , REMON_PERMISSION_REQUEST )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if( requestCode == REMON_PERMISSION_REQUEST ) {
            val deniedList = arrayListOf<String>()
            if( grantResults.isNotEmpty() ) {
                for( i in grantResults.indices ) {
                    if( grantResults[i] == PackageManager.PERMISSION_DENIED ) {
                        deniedList.add( permissions[i])
                    }
                }
            }

            if( deniedList.isNotEmpty()) {
                // 특정 권한이 없는 경우
<<<<<<< HEAD
                Snackbar.make( binding.rootLayout, "권한을 체크하세요.", Snackbar.LENGTH_SHORT).show()

                binding.etChannelName.isEnabled = false
                binding.btnConnect.isEnabled = false
            } else {
                binding.etChannelName.isEnabled = true
                binding.btnConnect.isEnabled = true
=======
                Snackbar.make( rootLayout, "권한을 체크하세요.", Snackbar.LENGTH_SHORT).show()

               etChannelName.isEnabled = false
                btnConnect.isEnabled = false
            } else {
                etChannelName.isEnabled = true
                btnConnect.isEnabled = true
>>>>>>> a31e77a347a4a993e36794e55de66658b938306d
            }
        }
    }

    private fun convertDpToPixel(context: Context, dp:Int) : Int {
        val resources = context.resources
        val metrics = resources.displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return px.toInt()

    }

}