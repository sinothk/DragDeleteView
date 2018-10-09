# DragDeleteView 拖拽删除
      <com.sinothk.widget.dragDeleteView.DragDeleteView
      android:id="@+id/text"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:layout_margin="10dp"
      android:background="@drawable/drag_delete_view_bg"
      android:paddingLeft="4dp"
      android:paddingRight="4dp"
      android:text="99+"
      android:textColor="#FFFFFF"
      android:textSize="14sp" />
        
# JAVA
      dragDeleteView.setOnDragListener(new DragDeleteView.OnDragListener() {
          @Override
          public void OnDragCompleted() {
              Toast.makeText(MainActivity.this, "OnDragCompleted", Toast.LENGTH_SHORT).show();
          }
      });

      datas = new ArrayList<>();
      for (int i = 1; i < 10; i++) {
          datas.add("item" + i);
      }
