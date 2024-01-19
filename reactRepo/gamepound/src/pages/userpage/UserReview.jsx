import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import ReviewStats from './ReviewStats';
import ReviewList from './ReviewList';
import { useUserMemory } from '../../component/context/UserContext';

const StyledUserReviewDiv = styled.div`
    width: 1120px;
    padding: 50px;
    padding-left: 20px;
    display: flex;
    justify-content: space-between;
`;

const UserReview = () => {

    const {loginMemberVo} = useUserMemory();

    const [statVo, setStatVo] = useState([]);
    const [reviewList, setReviewList] = useState([]); 

    const memberNo = {
        "memberNo": loginMemberVo.no
    }
    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/userpage/review", {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(memberNo)
        })
        .then(resp => resp.json())
        .then(data => {
            setReviewList(data.reviewList);
            setStatVo(data.statVo);
        })
    }, [])

    return (
        <StyledUserReviewDiv>
            {
                reviewList !== null
                ?
                <>
                    <ReviewStats statVo = {statVo}/>
                    <ReviewList reviewList = {reviewList}/>
                </>
                :
                <>
                    <h3> 등록된 후기가 없습니다 </h3>
                </>
            }
        </StyledUserReviewDiv>
    );
};

export default UserReview;