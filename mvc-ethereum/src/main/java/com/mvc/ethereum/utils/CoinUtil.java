package com.mvc.ethereum.utils;

import com.mvc.ethereum.model.CoinInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

/**
 * coin trans util
 *
 * @author qiyichen
 * @create 2018/1/9 17:38
 */
@Data
public class CoinUtil {

    public static HashMap<BigInteger, CoinInfo> coinMap = new HashMap<>();

    public static Double wei2Value(BigInteger coinId, BigInteger balance) {
        CoinInfo coinInfo = coinMap.get(coinId);
        BigDecimal b = new BigDecimal(balance);
        Double rslt = b.divide(new BigDecimal(coinInfo.getRatio()), coinInfo.getDigit(), BigDecimal.ROUND_HALF_UP).doubleValue();
        return rslt;
    }

    public static Double wei2Value(String  type, BigInteger balance) {
        BigInteger coinId = getId(type);
        CoinInfo coinInfo = coinMap.get(coinId);
        BigDecimal b = new BigDecimal(balance);
        Double rslt = b.divide(new BigDecimal(coinInfo.getRatio()), coinInfo.getDigit(), BigDecimal.ROUND_HALF_UP).doubleValue();
        return rslt;
    }

    public static String getUnit(BigInteger coinId) {
        return coinMap.get(coinId).getAbbr();
    }

    public static String getName(BigInteger coinId) {
        return coinMap.get(coinId).getName();
    }

    public static String getNameEn(BigInteger coinId) {
        return coinMap.get(coinId).getNameEn();
    }

    public static BigInteger Value2wei(BigDecimal value, String type) {
        value = value.setScale(5, RoundingMode.HALF_DOWN);
        Set<Map.Entry<BigInteger, CoinInfo>> set = coinMap.entrySet();
        for(Map.Entry<BigInteger, CoinInfo> map : set){
            CoinInfo coin = map.getValue();
            if (coin.getAbbr().equals(type)){
                BigInteger result = value.multiply(new BigDecimal(coin.getRatio())).setScale(5,RoundingMode.HALF_DOWN).toBigInteger();
                return result;
            }
        }
        return BigInteger.valueOf(0);
    }

    public static BigInteger getId(String type) {
        Set<Map.Entry<BigInteger, CoinInfo>> set = coinMap.entrySet();
        for(Map.Entry<BigInteger, CoinInfo> map : set){
            CoinInfo coin = map.getValue();
            if (coin.getAbbr().equals(type)){
                return coin.getId();
            }
        }
        return  null;
    }

    public static String getContractAddress(String type) {
        return coinMap.get(getId(type)).getAddress();
    }

}
