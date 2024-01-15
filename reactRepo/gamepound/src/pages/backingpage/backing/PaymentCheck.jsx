import React from 'react';
import styled from 'styled-components';
import { useBackingMemory } from '../../../component/context/BackingContext';
import {useNavigate, useNavigation} from 'react-router-dom';
import { useUserMemory } from '../../../component/context/UserContext';

const StyledPaymentCheckDiv = styled.div`
    width: 380px;
    height: 350px;
    margin-top: 20px;
    padding-bottom: 20px;
    
    & > .final_amount {
        height: 60px;
        border: 1px solid var(--red-color);
        border-radius: 5px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        
        & > span {
            color: var(--red-color);
            padding-left: 20px;
            padding-right: 20px;
            font-weight: 400;
        }
    }

    & > .payment_due {
        font-size: 13px;
        padding: 10px;

        & > span {
            font-weight: 600;
            color: var(--red-color);
        }
    }

    & > .checkbox_area {
        padding: 10px;

        & > label {

            & > input {
                margin-right: 10px;
            }

        }
    }

    & > button {
        height: 60px;
        width: 100%;
        border-radius: 5px;
        margin-top: 20px;
        background-color: var(--red-color);
        font-size: 16px;
        color: white;
        font-weight: 400;
        letter-spacing: 0.4px;
    }
`;

const PaymentCheck = () => {

    // useNavigate
    const navigate = useNavigate();

    // useContext
    const loginMemberVo = useUserMemory();

    const dataSet = useBackingMemory();
    const back = dataSet.dataVo;
    console.log(back);
    
    // 체크박스 체크여부 확인 함수
    const checkCheckInput = () => {
        const checkbox = document.querySelector('input[name=check_yn]');
        let is_checked = false;
        if(checkbox.checked) {
            is_checked = true;
        }

        return is_checked;
    }

    const checkCardInput = () => {
        let check1 = false;
        if(back.cardNo1 && back.cardNo2 && back.cardNo3 && back.cardNo4) {
            check1 = true;
        } 

        let check2 = false;
        if(back.cardNo1.length === 4 && back.cardNo2.length === 4 && back.cardNo3.length === 4 && back.cardNo4.length === 4) {
            check2 = true;
        }

        let check3 = false;
        if(back.validThru1 && back.validThru2) {
            check3 = true;
        }

        let check4 = false;
        if(back.validThru1.length === 2 && back.validThru2.length === 2) {
            check4 = true;
        }

        let check5 = false;
        if(back.cardPwd && back.birthDate) {
            check5 = true;
        }

        let check6 = false;
        if(back.cardPwd.length === 2 && back.birthDate.length === 6) {
            check6 = true;
        }
        
        if(check1 === true && check2 === true && check3 === true && check4 === true &&
            check5 === true && check6 === true) {
                return true;
        } else {
            return false;
        }

    }

    // 카카오페이 결제등록창 연동
    const getKakaoPayApi = () => {

        let { IMP } = window;
        IMP.init('imp44278700');

        if(typeof IMP === 'undefined') {
            alert("not loaded");
            return;
        }
        
        const paymentData = {
            pg: 'kakaopay',
            merchant_uid: 'back_' + loginMemberVo.no + new Date().getTime(),
            name: '최초인증결제',
            amount: 0,
            name: back.projectName + '_' + back.rewardName,
            customer_uid: loginMemberVo.email + '_' + new Date().getTime(),
            buyer_email: loginMemberVo.email,
            m_redirect_url: 'http://localhost:3000/back/completed/'+back.projectNo
        }

        IMP.request_pay(paymentData, ({success, merchant_uid, error_msg})=>{
            if(success) {

                dataSet.setDataVo({
                    ...back,
                    "customerUid": paymentData.customer_uid
                })

                fetch("http://127.0.0.1:8889/gamepound/back/process", {
                    method: "post",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(back)
                })
                .then(resp => resp.json())
                .then(data => {
                    console.log(data);
                    if(data.result==="success") {
                            navigate("/back/completed/" + back.projectNo);
                    }
                })
            } else {
                
            }
        })
    }

    const handleBackBtnClick = (e) => {

        e.preventDefault();

        // 유효성 체크
        // PaymentType undefined체크
        let paymentTypeDefined = false;
        if(back.paymentType) {
            paymentTypeDefined = true;
        }

        // TODO: 이미 후원한 프로젝트는 또 후원 못하게 유효성 체크
        
        
        if(paymentTypeDefined) {
            
            if(back.paymentType==='kakaopay') {
                getKakaoPayApi();
            } else {
                // PaymentType이 카드 결제일 시 카드정보 null 및 길이 체크
                const cardInfoOk = checkCardInput();
                // 체크박스 체크 여부
                const checkboxOk = checkCheckInput();
                cardInfoOk && checkboxOk 
                ? 
                fetch("http://127.0.0.1:8889/gamepound/back/process", {
                        method: "post",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(back)
                })
                .then(resp => resp.json())
                .then(data => {
                    if(data.result==="success") {
                            navigate("/back/completed/" + back.projectNo);
                    }
                })
                : 
                alert("후원 정보가 빠진 곳 없이 작성되었는지 확인해주세요.");
            }
        }
        
    }

    

    return (
        <StyledPaymentCheckDiv>
            <div className="final_amount">
                <span>최종 후원 금액</span>
                <span>{back.rewardAmount} 원</span>
            </div>

            <div className="payment_due">프로젝트 성공 시, 결제는 <span>{back.paymentDueDate}</span> 에 진행됩니다.<br/> 
                프로젝트가 무산 또는 중단된 경우, 예약된 결제는 자동으로 취소됩니다.
            </div>
            
            <div className="checkbox_area">
                <label><input type="checkbox" name='check_yn' />개인정보 제3자 제공 동의</label>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
            </div>
            
            <button onClick={handleBackBtnClick}>후원하기</button>
        </StyledPaymentCheckDiv>
    );
};

export default PaymentCheck;