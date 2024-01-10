import React, { useEffect, useState } from 'react';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledStoryDiv = styled.div`
    width: 100%;
    & > ul{
        & > li:nth-child(2n){
            font-size: 19px;
            font-weight: 500;
            padding-top: 60px;
            padding-bottom: 60px;
        }
        & > li:last-child{
            padding-bottom: 100px;
        }
        & > li:nth-child(1){
            background-color: #4eb56b2b;
            padding: 20px;
            width: fit-content;
            margin-top: 40px;
            margin-bottom: 40px;
        }
    }

    & > div{
        border: 1px solid #d6d6d6;
        border-radius: 5px;
        padding: 25px;
        height: fit-content;
        & > div:first-child{
            font-size: 18px;
            font-weight: 500;
            margin-bottom: 20px;
        }
        & > div:nth-child(2){
            display: flex;
            align-items: center;
            margin-bottom: 10px;
            & > div{
                width: 40px;
                height: 40px;
                font-size: 5px;
            }
            & > span{
                font-weight: 500;
                margin-left: 40px;
            }
        }
    }

`;



const PrelaunchStoryPage = () => {

    const [detailPrelaunchStoryVo, setDetailPrelaunchStoryVo] = useState([]);


    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/detail/prelaunch/story?no=1")
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            setDetailPrelaunchStoryVo(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, []);








    return (<StyledAllDiv>
        <StyledStoryDiv>
            <ul>
                <li>❗ 해당 프로젝트 정보는 미리 보기 용으로 상세 내용은 펀딩 시작 전 변경될 수 있습니다.</li>
                <li>| 프로젝트 소개</li>
                <li>{detailPrelaunchStoryVo.txtDescription}</li>
                <li>| 팀 소개</li>
                <li>{detailPrelaunchStoryVo.txtTeam}</li>
                <li>| 선물 설명</li>
                <li>{detailPrelaunchStoryVo.txtItem}</li>
            </ul>
        </StyledStoryDiv>
    </StyledAllDiv>);
};

export default PrelaunchStoryPage;