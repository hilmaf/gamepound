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
    useEffect(()=>{
        fetch("http://127.0.0.1:8889/gamepound/userpage/review?user=" + loginMemberVo.no)
        .then(resp => resp.json())
        .then(data => {
            setReviewList(data.reviewList);
            setStatVo(data.statVo);
        })
    }, [])

    return (
        <StyledUserReviewDiv>
            <ReviewStats statVo = {statVo}/>
            <ReviewList reviewList = {reviewList}/>
        </StyledUserReviewDiv>
    );
};

export default UserReview;