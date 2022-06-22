package com.vivek.practicedaggerhilt


interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}
