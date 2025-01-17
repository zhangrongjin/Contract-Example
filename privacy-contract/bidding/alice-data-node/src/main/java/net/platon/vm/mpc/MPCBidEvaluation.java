
/*
 * may be some declaration here.
 */
package net.platon.vm.mpc;

import net.platon.vm.sdk.client.*;
import net.platon.vm.sdk.utils.JDBCUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Attention! This file was auto-generated, you just need to implement the "TODO SECTIONS".
 * The class name "MPCBidEvaluation" is just to named this file, you can rename "MPCBidEvaluation" what you like.
 * More details ref "MPCBidEvaluation-README.TXT".
 * <p>
 * DIGEST:
 * <p>
 * IR NAME: MPCBidEvaluation
 * IR HASH: 6d894588b21dd56da2a3b971a61b6201
 * <p>
 * IR FUNC HASH(MD5)                 IR FUNC NAME         IR FUNC PROT
 * 1d11e5749603f6fb0e21e611c9bec02f  BidEvaluationResult  BidEvaluationResult(Bidder,int)
 */

interface mpc_ii_6d894588b21dd56da2a3b971a61b6201 extends IIInterface {
}

public class MPCBidEvaluation implements mpc_ii_6d894588b21dd56da2a3b971a61b6201 {
    private HashMap<String, MpcCallbackInterface> funcInterfaces = new HashMap<String, MpcCallbackInterface>() {{
        put("mpc_f_1d11e5749603f6fb0e21e611c9bec02f_01", new MPCBidEvaluation_BidEvaluationResult_Bidder_int_01());
        put("mpc_f_1d11e5749603f6fb0e21e611c9bec02f_02", new MPCBidEvaluation_BidEvaluationResult_Bidder_int_02());
    }};

    public MpcCallbackInterface getInstance(String instance_hash) {
        if (funcInterfaces.containsKey(instance_hash)) {
            return funcInterfaces.get(instance_hash);
        }
        return null;
    }

    public HashMap<String, MpcCallbackInterface> getInstances() {
        return funcInterfaces;
    }

    abstract class MpcCallbackBase_6d894588b21dd56da2a3b971a61b6201 implements MpcCallbackInterface {
        public abstract byte[] inputImpl(final InputRequestPara para);

        public byte[] input(final InputRequestPara para) {
            // TODO: do what you want to do, before call inputImpl
            return inputImpl(para);
        }

        public void error(final InputRequestPara para, ErrorCode error) {
            // TODO: do what you want to do
        }

        public void result(final InputRequestPara para, final byte[] data) {
            // TODO: do what you want to do
        }
    }

    abstract class mpc_i_6d894588b21dd56da2a3b971a61b6201 extends MpcCallbackBase_6d894588b21dd56da2a3b971a61b6201 {
    }

    abstract class mpc_f_1d11e5749603f6fb0e21e611c9bec02f_01 extends mpc_i_6d894588b21dd56da2a3b971a61b6201 {
        public byte[] input_x_default() {
            return Data.Int32(0);
        }
    }

    abstract class mpc_f_1d11e5749603f6fb0e21e611c9bec02f_02 extends mpc_i_6d894588b21dd56da2a3b971a61b6201 {
        public byte[] input_x_default() {
            return network.platon.bidevaluation.BidEvaluation.Bidder.newBuilder().build().toByteArray();
        }
    }


    /**
     * BidEvaluationResult(Bidder,int)
     */
    final class MPCBidEvaluation_BidEvaluationResult_Bidder_int_01 extends mpc_f_1d11e5749603f6fb0e21e611c9bec02f_01 {
        public byte[] inputImpl(final InputRequestPara para) {
            network.platon.bidevaluation.BidEvaluation.Bidder.Builder builder = network.platon.bidevaluation.BidEvaluation.Bidder.newBuilder();
            // TODO: assemble data

            List<Map<String, String>> lm = JDBCUtil.executeQuery("select * from t_bid_data where flag = 2 order by id asc limit 1");
            if (lm.size() == 0) {
                builder.setA(0);
                builder.setB(0);
                builder.setC(0);
            } else {
                Map<String, String> m = lm.get(0);
                String id = m.get("id");
                JDBCUtil.executeUpdate("update t_bid_data set flag = 1 where id = " + id);

                String aInput = m.get("aInput");
                String bInput = m.get("bInput");
                String cInput = m.get("cInput");

                builder.setA(Integer.parseInt(aInput == null ? "0" : aInput));
                builder.setB(Integer.parseInt(bInput == null ? "0" : bInput));
                builder.setC(Integer.parseInt(cInput == null ? "0" : cInput));
            }
            return builder.build().toByteArray();
        }
    }

    /**
     * BidEvaluationResult(Bidder,int)
     */
    final class MPCBidEvaluation_BidEvaluationResult_Bidder_int_02 extends mpc_f_1d11e5749603f6fb0e21e611c9bec02f_02 {
        public byte[] inputImpl(final InputRequestPara para) {
            int ret_value = 0;
            // TODO: assemble data

            List<Map<String, String>> lm = JDBCUtil.executeQuery("select * from t_bid_data where flag2 = 2 order by id asc limit 1");
            if (lm.size() > 0) {
                Map<String, String> m = lm.get(0);
                String id = m.get("id");
                JDBCUtil.executeUpdate("update t_bid_data set flag2 = 1 where id = " + id);

                String pInput = m.get("pInput");

                ret_value = Integer.parseInt(pInput == null ? "0" : pInput);
            }
            return Data.Int32(ret_value);
        }
    }

}
