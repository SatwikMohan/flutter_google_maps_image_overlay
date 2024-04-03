package com.example.method_channel_flutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.method_channel_flutter.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import io.flutter.embedding.android.FlutterActivity

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnPolylineClickListener,
    GoogleMap.OnPolygonClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(40.714086, -74.228697)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

//        val polyline1 = googleMap.addPolyline(
//            PolylineOptions()
//            .clickable(true)
//            .add(
//                LatLng(-35.016, 143.321),
//                LatLng(-34.747, 145.592),
//                LatLng(-34.364, 147.891),
//                LatLng(-33.501, 150.217),
//                LatLng(-32.306, 149.248),
//                LatLng(-32.491, 147.309)))

        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-23.684, 133.903), 4f))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(40.714086, -74.228697), 4f))

        // Set listeners for click events.
        googleMap.setOnPolylineClickListener(this)
        googleMap.setOnPolygonClickListener(this)

        val newarkLatLng = LatLng(40.714086, -74.228697)
        val newarkMap = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.overlay_image))
            .position(newarkLatLng, 800f, 600f)
        googleMap.addGroundOverlay(newarkMap)

    }

    override fun onPolylineClick(p0: Polyline) {
        TODO("Not yet implemented")
    }

    override fun onPolygonClick(p0: Polygon) {
        TODO("Not yet implemented")
    }
}