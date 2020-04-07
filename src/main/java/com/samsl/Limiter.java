package com.samsl;

import org.apache.commons.collections4.queue.CircularFifoQueue;

public  class Limiter {
    private static String hostsArray[] = null;
    private static String portsArray[] = null;

    public static String querySplit(String query, int queryIndex, int divider){
        Integer totalCount = getTotalCount(query);
        return (queryIndex==1)? query.substring(0,query.lastIndexOf("limit"))+"limit "+getOffSet(totalCount,divider,queryIndex): query.substring(0,query.lastIndexOf("limit"))+"limit "+getOffSet(totalCount,divider,queryIndex-1)+","+getCount(totalCount,divider);
    }

    public static Integer getOffSet(Integer totalCount, Integer divider, int queryIndex){
        return totalCount/divider*queryIndex+(totalCount%divider);
    }
    public static Integer getCount(Integer totalCount, Integer divider){
        return totalCount/divider;
    }
    public static Integer getTotalCount(String query){
        return Integer.parseInt(query.substring(query.lastIndexOf("limit")).replaceFirst("limit","").replaceAll(";","").trim());
    }
    public static String getSeperatedHostName(String hostString, int iterationIndex){
        if (hostsArray == null){
           hostsArray = hostString.split(",");
        }
        return hostsArray[iterationIndex-1];
    }

    public static int getSeperatedPortNumber(String portsString, int iterationIndex){
        if (portsArray == null){
            portsArray = portsString.split(",");
        }
        return Integer.parseInt(portsArray[iterationIndex-1]);
    }
}
