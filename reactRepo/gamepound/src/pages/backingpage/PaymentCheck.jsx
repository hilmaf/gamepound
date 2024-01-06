import React from 'react';
import styled from 'styled-components';

const StyledPaymentCheckDiv = styled.div`
    width: 380px;
    height: 350px;
    margin-top: 20px;
    padding-bottom: 20px;
    
    & > .final_amount {
        height: 60px;
        border: 1px solid #3d3d3d;
    }
`;

const PaymentCheck = () => {

    const handleBackBtnClick = () => {
        
    }

    return (
        <StyledPaymentCheckDiv>
            <div className="final_amount">
                <span>최종 후원 금액</span>
                <span>29,000원</span>
            </div>

            <div className="payment_due">프로젝트 성공 시, 결제는 2024.01.06 에 진행됩니다. 
                프로젝트가 무산되거나 중단된 경우, 예약된 결제는 자동으로 취소됩니다.
            </div>
            
            <div className="checkbox_area">
                <input type="checkbox" name="check"></input>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "/>
            </div>
            
            <button onClick={handleBackBtnClick}>후원하기</button>
        </StyledPaymentCheckDiv>
    );
};

export default PaymentCheck;