import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import styled from 'styled-components';

const StyledAllDiv = styled.div`
    width: 100%;
`;
const StyledStoryDiv = styled.div`
    width: 100%;
    & > ul{
        & > li:nth-child(2n+1){
            font-size: 19px;
            font-weight: 500;
            padding-top: 60px;
            padding-bottom: 60px;
        }
        & > li:last-child{
            padding-bottom: 100px;
        }
    }
`;

const StoryPage = () => {

    const { no }= useParams();

    const [detailStoryVo, setDetailStoryVo] = useState([]);


    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/project/detail/story?no=" + no)
        .then((resp)=>{return resp.json()})
        .then((data)=>{
            setDetailStoryVo(data);
        })
        .catch((e)=>{console.log("오류 : " + e);})
        ;
    }, [no]);




    return (
        <StyledAllDiv>
            <StyledStoryDiv>
                <ul>
                    <li>| 프로젝트 소개</li>
                    <li>{detailStoryVo.txtDescription}</li>
                    <li>| 프로젝트 예산</li>
                    <li>{detailStoryVo.txtBudget}</li>
                    <li>| 프로젝트 일정</li>
                    <li>{detailStoryVo.txtSchedule}</li>
                    <li>| 팀 소개</li>
                    <li>{detailStoryVo.txtTeam}</li>
                    <li>| 선물 설명</li>
                    <li>{detailStoryVo.txtItem}</li>
                </ul>
            </StyledStoryDiv>
        </StyledAllDiv>
    );
};

export default StoryPage;