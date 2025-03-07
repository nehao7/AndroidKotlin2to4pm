package com.example.androidkt_2to4_6m.Realtimedatabase.firebase

import com.o7services.androidkotlin2to4pm.realtimedatabase.MenuModel


interface ClickInterface {
    fun editClick(menuModel: MenuModel, position:Int)
    fun deleteClick(menuModel: MenuModel,position: Int)


}